package core;

import java.util.List;

public class Author {
    public final String name;
    public final String hIndex;
    public final Integer publicationsNr;
    public final List<Publication> publications;

    public Author(String name, String hIndex, List<Publication> publications) {
        this.name = name;
        this.hIndex = hIndex;
        this.publicationsNr = publications.size();
        this.publications = publications;
    }
}
