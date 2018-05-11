package core.scopus;

import core.entities.Author;
import core.entities.Publication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Created by Andrei on 5/11/18.
 */
public class ScopusConnector {
    //    private static final String ApiKey = "72e8903b0eac9dc225c60d511b2bd119";
    private static String firstName = "Petrica";
    private static String lastName = "Pop";
    private static int i = 0;
    private static Author author = new Author();


    public ScopusConnector(String nameToSearch) {
//        this.nameToSearch = nameToSearch;
        if (nameToSearch.split("\\w+").length > 1) {

            lastName = nameToSearch.substring(nameToSearch.lastIndexOf(" ") + 1);
            firstName = nameToSearch.substring(0, nameToSearch.lastIndexOf(' '));
        } else {
            firstName = nameToSearch;
        }

    }

    public static void main(String[] args) {
//        getAuthorData();
    }

    public static Author getAuthorData(String nameToSearch) {
        if (nameToSearch.split("\\w+").length > 1) {

            lastName = nameToSearch.substring(nameToSearch.lastIndexOf(" ") + 1);
            firstName = nameToSearch.substring(0, nameToSearch.lastIndexOf(' '));
        } else {
            firstName = nameToSearch;
        }
        Author author = new Author();

        String string = "https://api.elsevier.com/content/author/author_id/" + getAuthorId() + "?apiKey=72e8903b0eac9dc225c60d511b2bd119&httpAccept=application%2Fjson";
        JSONObject json;
        try {
            json = readJsonFromUrl(string);
            JSONArray publications = json.getJSONArray("author-retrieval-response");
            JSONObject object = publications.getJSONObject(0);
            if (Objects.equals(object.getString("@status"), "found")) {
                JSONObject coreData = object.getJSONObject("coredata");
                author.setCitations(coreData.getString("citation-count"));
                author.setPublicationsNr(coreData.getInt("document-count"));

                JSONArray pubList = object.getJSONObject("author-profile").getJSONArray("journal-history");
                for (int i = 0; i < pubList.length(); i++) {
                    JSONObject pub = pubList.getJSONObject(i);
                    Publication pubObject = new Publication();
                    pubObject.setTitle(pub.getString("sourcetitle"));
//                    pubObject.setYear()
                    author.addPublication(pubObject);
                }
            }
//            author.setPublicationsNr();
            System.out.println(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return author;
    }

    private static String getAuthorId() {
        String string = "https://api.elsevier.com/content/search/author?query=authlast(" + lastName + ")%20and%20authfirst(" + firstName + ")&apiKey=72e8903b0eac9dc225c60d511b2bd119";
        JSONObject json;
        String authorId;
        try {
            json = readJsonFromUrl(string);
            String result = json.getJSONObject("search-results").getJSONArray("entry").getJSONObject(0).getString("dc:identifier");

            authorId = result.substring(result.lastIndexOf(':') + 1);
            return authorId;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
