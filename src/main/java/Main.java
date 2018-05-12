import core.scholar.GoogleScholarNew;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GoogleScholarNew googleScholarProvider = new GoogleScholarNew();
        System.out.println(googleScholarProvider.getAuthor("Stephen Hawking"));
    }
}