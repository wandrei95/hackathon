import core.scholar.GoogleScholarNew;
import core.scholar.GoogleScholarProvider;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GoogleScholarNew googleScholarProvider = new GoogleScholarNew("Petrica Pop");
        System.out.println(googleScholarProvider.getAuthor());
    }
}