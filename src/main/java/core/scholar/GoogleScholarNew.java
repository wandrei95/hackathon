package core.scholar;

import core.Author;
import core.Publication;
import core.doc.DocProvider;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleScholarNew {
    public static final String URL_SEARCH = "https://scholar.google.ro/citations?view_op=search_authors&mauthors=";
    public static String AUTHOR_TO_LOOK_FOR = null;
    public static final String UNKNOWN_SHIT = "&hl=en&oi=drw";
    public static String baseUrl = "https://scholar.google.ro/";

    public GoogleScholarNew(String author) {
        String firstName = StringUtils.substringBefore(author, " ");
        String lastName = StringUtils.substringAfter(author, " ");
        AUTHOR_TO_LOOK_FOR = firstName + "+" + lastName;
    }

    public Document getInitialDocToParse() {
        Document document = null;
        try {
            document = DocProvider.getDocument(URL_SEARCH + AUTHOR_TO_LOOK_FOR + UNKNOWN_SHIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Author getAuthor() throws IOException {
        Document document = getInitialDocToParse();
        String informationsUrl = baseUrl + getUrlOfInfos(document);

        Document authorInformations = DocProvider.getDocument(informationsUrl);
        Elements elements = authorInformations.select("a.gsc_a_at");
        System.out.println(elements);
        return null;
    }

    private String getUrlOfInfos(Document document) {
        String authorUrl = StringUtils
                .substringAfter(document.select("h3.gsc_oai_name").select("a").toString(), "/");
        authorUrl = StringUtils.substringBefore(authorUrl, ";oe");
        return authorUrl;
    }

    private List<Publication> getPublicationsByAuthor(Document authorInformations) {
        List<Publication> publications = new ArrayList<Publication>();
        Elements elements = authorInformations.select("a.gsc_a_at");
        for (Element element : elements) {
            String publicationTitle = element.text();
            Publication publication = new Publication();
            publication.setTitle(publicationTitle);

        }
        return null;
    }

}
