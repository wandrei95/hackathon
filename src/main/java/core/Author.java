package core;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String i10index;
    private String hIndex;
    private Integer publicationsNr;
    private String citations;
    private List<Publication> publications = new ArrayList<Publication>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public Author(String name, String i10index, String hIndex, Integer publicationsNr, String citations, List<Publication> publications) {
        this.name = name;
        this.i10index = i10index;
        this.hIndex = hIndex;
        this.publicationsNr = publicationsNr;
        this.citations = citations;
        this.publications = publications;
    }

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
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

    public String getI10index() {
        return i10index;
    }

    public void setI10index(String i10index) {
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
