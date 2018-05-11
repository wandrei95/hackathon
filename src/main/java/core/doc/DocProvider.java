package core.doc;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocProvider {
    private DocProvider() {
    }

    private static void addHeader(Connection conn) {
        conn.header("User-Agent", "Mozilla");
        conn.header("Accept", "text/html,text/plain");
        conn.header("Accept-Language", "en-us,en");
        conn.header("Accept-Encoding", "gzip");
        conn.header("Accept-Charset", "utf-8");
    }

    public static Document getDocument(String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        conn.timeout(0);
        addHeader(conn);
        return conn.get();
    }
}
