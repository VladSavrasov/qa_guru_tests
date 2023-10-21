package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.annotations.SerializedName;

public class GlossaryObject {

    private String title;

    @JsonAlias("GlossDiv")
    private GlossDiv[] glossDiv;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossDiv[] getGlossDiv() {
        return glossDiv;
    }

    public void setGlossDiv(GlossDiv[] glossDiv) {
        this.glossDiv = glossDiv;
    }
}
