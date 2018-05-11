package core.scholar;

import core.Author;
import core.doc.DocProvider;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class GoogleScholarProvider {
    private static final String STARTING_URL = "https://scholar.google.com/scholar?";
    private static final String SEARCH_URL = "start=0&q=";
    private static final String UNKNOWN_SHIT = "&hl=en&as_sdt=0,5";
    private static String SEARCH_AUTHOR_NAME = null;

    public GoogleScholarProvider(String author) {
        String firstName = StringUtils.substringBefore(author, " ");
        String lastName = StringUtils.substringAfter(author, " ");
        SEARCH_AUTHOR_NAME = firstName + "+" + lastName;
    }

    public Document getInitialDocToParse() {
        Document document = null;
        try {
            document = DocProvider.getDocument(STARTING_URL + SEARCH_URL + SEARCH_AUTHOR_NAME + UNKNOWN_SHIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Author getAuthor() {
        Document document = getInitialDocToParse();
        Elements elements = document.select("div.gs_r");
        for (Element element : elements) {
            Elements utilInfo = element.select("H3.gs_rt");
            if (utilInfo.toString().contains("[BOOK]")) {
                String bookName = getBookNameFromElement(element);

            }

        }
        return null;
    }

    private String getBookNameFromElement(Element element) {
        Elements links = element.select(".gs_rt a[href]");
        return links.text();
    }
}
