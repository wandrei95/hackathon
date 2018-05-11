package core;

public class Publication {
    public int citations;
    public int year;
    public String authors;
    public String title;

    public Publication() {
    }

    public Publication(int citations, int year, String authors, String title) {
        this.citations = citations;
        this.year = year;
        this.authors = authors;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
