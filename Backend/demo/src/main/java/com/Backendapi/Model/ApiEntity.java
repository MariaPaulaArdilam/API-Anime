package com.Backendapi.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class ApiEntity {

    private String title;
    private String image;
    private Double score;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
