package core.entities;

import java.util.ArrayList;
import java.util.List;

public class Publication {
    private String citations;
    private String year;
    private List<String> authors;
    private String title;
    private String publisher;
    private List<Citations>citedBy = new ArrayList<>();

    public Publication() {
    }

    public Publication(String citations, String year, List<String> authors, String title, String publisher,List<Citations>citedBy) {
        this.citations = citations;
        this.year = year;
        this.authors = authors;
        this.title = title;
        this.publisher = publisher;
        this.citedBy = citedBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<Citations> getCitedBy() {
        return citedBy;
    }

    public void setCitedBy(List<Citations> citedBy) {
        this.citedBy = citedBy;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
