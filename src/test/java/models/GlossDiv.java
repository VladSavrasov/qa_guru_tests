package models;


import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public class GlossDiv {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortAs() {
        return sortAs;
    }

    public void setSortAs(String sortAs) {
        this.sortAs = sortAs;
    }

    public String getGlossTerm() {
        return glossTerm;
    }

    public void setGlossTerm(String glossTerm) {
        this.glossTerm = glossTerm;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public List<String> getGlossSeeAlso() {
        return glossSeeAlso;
    }

    public void setGlossSeeAlso(List<String> glossSeeAlso) {
        this.glossSeeAlso = glossSeeAlso;
    }

    private String title;
    @JsonAlias("ID")
    private int id;
    @JsonAlias("SortAs")
    private String sortAs;
    @JsonAlias("GlossTerm")
    private String glossTerm;
    @JsonAlias("Acronym")
    private String acronym;

    @JsonAlias("Abbrev")
    private String abbrev;
    @JsonAlias("GlossSeeAlso")
    private List<String> glossSeeAlso = new ArrayList<String>();

}
