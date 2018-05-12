package core.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Author {
    private String name;
    private String i10index;
    private String hIndex;
    private Integer publicationsNr;
    private String citations;
    private String photoUrl;
    private List<Publication> publications = new ArrayList<Publication>();
    private Map<String, Integer> citationHistory = new HashMap<>();
    private String imageUrl;
    private String organization;
    List<String> citedLocations = new ArrayList<>();

    public Author() {
    }

    public Author(String name, String i10index, String hIndex, Integer publicationsNr, String citations, String photoUrl, List<Publication> publications, Map<String, Integer> citationHistory, String organization, String imageUrl) {
        this.name = name;
        this.i10index = i10index;
        this.hIndex = hIndex;
        this.publicationsNr = publicationsNr;
        this.citations = citations;
        this.photoUrl = photoUrl;
        this.publications = publications;
        this.citationHistory = citationHistory;
        this.imageUrl = imageUrl;
        this.organization = organization;
    }


    public List<String> getCitedLocations() {
        return citedLocations;
    }

    public void setCitedLocations(List<String> citedLocations) {
        this.citedLocations = citedLocations;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Map<String, Integer> getCitationHistory() {
        return citationHistory;
    }

    public void setCitationHistory(Map<String, Integer> citationHistory) {
        this.citationHistory = citationHistory;
    }

    public Author(String name) {
        this.name = name;
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
