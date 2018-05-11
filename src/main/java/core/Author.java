package core;

import java.util.List;

public class Author {
    public String name;
    public int i10index;
    public String hIndex;
    public Integer publicationsNr;
    public List<Publication> publications;

    public Author() {
    }

    public Author(String name, int i10index, String hIndex, Integer publicationsNr, List<Publication> publications) {
        this.name = name;
        this.i10index = i10index;
        this.hIndex = hIndex;
        this.publicationsNr = publicationsNr;
        this.publications = publications;
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setI10index(int i10index) {
        this.i10index = i10index;
    }

    public String gethIndex() {
        return hIndex;
    }

    public void sethIndex(String hIndex) {
        this.hIndex = hIndex;
    }

    public Integer getPublicationsNr() {
        return publicationsNr;
    }

    public void setPublicationsNr(Integer publicationsNr) {
        this.publicationsNr = publicationsNr;
    }

}
