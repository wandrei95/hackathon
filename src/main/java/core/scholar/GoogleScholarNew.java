package core.scholar;

import core.doc.DocProvider;
import core.entities.Author;
import core.entities.Publication;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class GoogleScholarNew {
    private static final String URL_SEARCH = "https://scholar.google.ro/citations?view_op=search_authors&mauthors=";
    private static String AUTHOR_TO_LOOK_FOR = null;
    private static final String UNKNOWN_SHIT = "&hl=en&oi=drw";
    private static String baseUrl = "https://scholar.google.ro/";
    public static final String CITATION_HISTORY_URL = "#d=gsc_md_hist&p=&u=";

    private Document getInitialDocToParse() {
        Document document = null;
        try {
            document = DocProvider.getDocument(URL_SEARCH + AUTHOR_TO_LOOK_FOR + UNKNOWN_SHIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Author getAuthor(String authorName) throws IOException {
        String firstName = StringUtils.substringBefore(authorName, " ");
        String lastName = StringUtils.substringAfter(authorName, " ");
        AUTHOR_TO_LOOK_FOR = firstName + "+" + lastName;

        Document document = getInitialDocToParse();
        String informationsUrl = baseUrl + getUrlOfInfos(document);
        Document citationsInformations = DocProvider.getDocument(informationsUrl + CITATION_HISTORY_URL);

        Map<String, Integer> graphicsInfo = getCitationHistory(citationsInformations);

        Document authorInformations = DocProvider.getDocument(informationsUrl + "&cstart=0&pagesize=100");

        Author author = new Author(authorName);

        author.setCitationHistory(graphicsInfo);

        addAuthorInformations(author, authorInformations);
        int defaultPageSize = 100;
        int offset = 100;
        boolean shouldStop = false;
        boolean firstPageRequest = true;
        while (!shouldStop) {
            List<Publication> publications = getPublicationsByAuthor(authorInformations);
            if (publications.size() < 100 && !firstPageRequest) {
                shouldStop = true;
            }

            for (Publication publication : publications) {
                author.addPublication(publication);
                firstPageRequest = false;
            }
            offset += 100;
            authorInformations = DocProvider.getDocument(informationsUrl + "&cstart=" + offset + "pagesize=100");
        }
        return author;
    }

    private Map<String, Integer> getCitationHistory(Document citationsInformations) {
        Elements elements = citationsInformations.select("a.gsc_g_a");
        Map<String, Integer> graphicMap = new HashMap<>();
        int startingYear = 2018 - elements.size() + 1;
        for (Element element : elements) {
            graphicMap.put(String.valueOf(startingYear++), Integer.parseInt(element.text()));
        }
        return graphicMap;
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
        int index = -1;
        for (Element element : elements) {
            index++;
            //SET TITLE
            String publicationTitle = element.text();
            Publication publication = new Publication();
            publication.setTitle(publicationTitle);
            publication.setYear(getYearForPublicationBasedOnIndex(authorInformations, index));
            publication.setCitations(getCitatesBasedOnIndex(authorInformations, index));
            publication.setAuthors(Arrays.asList(getAuthorsBasedOnIndex(authorInformations, 2 * index).split(", ")));
            publication.setPublisher(getPublisherBasedOnIndex(authorInformations, 2 * index + 1));
            publications.add(publication);

        }
        return publications;
    }

    private String getPublisherBasedOnIndex(Document authorInformations, int index) {
        Elements elements = authorInformations.select("div.gs_gray");
        int actualIndex = -1;
        for (Element element : elements) {
            actualIndex++;
            if (actualIndex == index) {
                return element.text();
            }
        }
        return null;
    }


    private String getAuthorsBasedOnIndex(Document authorInformations, int index) {
        Elements elements = authorInformations.select("div.gs_gray");
        int actualIndex = -1;
        for (Element element : elements) {
            actualIndex++;
            if (actualIndex == index) {
                return element.text();
            }
        }
        return null;
    }

    private String getYearForPublicationBasedOnIndex(Document authorInformations, int index) {
        Elements elements = authorInformations.select("td.gsc_a_y");
        int actualIndex = -1;
        for (Element element : elements) {
            actualIndex++;
            if (actualIndex == index) {
                return element.text();
            }
        }
        return null;
    }

    private String getCitatesBasedOnIndex(Document authorInformations, int index) {
        Elements elements = authorInformations.select("td.gsc_a_c");
        int actualIndex = -1;
        for (Element element : elements) {
            actualIndex++;
            if (actualIndex == index) {
                return element.text();
            }
        }
        return null;
    }

    private void addAuthorInformations(Author author, Document authorInformations) {
        Elements elements = authorInformations.select("td.gsc_rsb_std");
        int idx = 0;
        author.setCitations(elements.text());
        for (Element element : elements) {
            if (idx == 0) {
                author.setCitations(element.text());
            }
            if (idx == 2) {
                author.sethIndex(element.text());
            }
            if (idx == 4) {
                author.
                        setI10index(element.text());
            }
            idx++;
        }
    }

}
