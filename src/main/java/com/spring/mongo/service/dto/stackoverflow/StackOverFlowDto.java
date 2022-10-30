package com.spring.mongo.service.dto.stackoverflow;

import java.util.Objects;

public class StackOverFlowDto {

    private String id;

    private String iconImageUrl;

    private String website;

    private String title;

    private String description;

    public StackOverFlowDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackOverFlowDto that = (StackOverFlowDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(iconImageUrl, that.iconImageUrl) &&
                Objects.equals(website, that.website) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iconImageUrl, website, title, description);
    }

    @Override
    public String toString() {
        return "StackOverFlowDto{" +
                "id='" + id + '\'' +
                ", iconImageUrl='" + iconImageUrl + '\'' +
                ", website='" + website + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


