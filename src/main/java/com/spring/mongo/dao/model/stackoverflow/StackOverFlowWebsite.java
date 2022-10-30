package com.spring.mongo.dao.model.stackoverflow;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "sites")
public class StackOverFlowWebsite {

    @Id
    private String id;

    @Field(name = "iconImageUrl")
    private String iconImageUrl;

    private String website;

    private String title;

    private String description;


    public StackOverFlowWebsite() {
    }

    private StackOverFlowWebsite(Builder builder) {
        setId(builder.id);
        setIconImageUrl(builder.iconImageUrl);
        setWebsite(builder.website);
        setTitle(builder.title);
        setDescription(builder.description);
    }

    public static Builder newBuilder() {
        return new Builder();
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
        StackOverFlowWebsite that = (StackOverFlowWebsite) o;
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
        return "StackoverflowWebsite{" +
                "id='" + id + '\'' +
                ", iconImageUrl='" + iconImageUrl + '\'' +
                ", website='" + website + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public static final class Builder {
        private String id;
        private String iconImageUrl;
        private String website;
        private String title;
        private String description;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder iconImageUrl(String val) {
            iconImageUrl = val;
            return this;
        }

        public Builder website(String val) {
            website = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public StackOverFlowWebsite build() {
            return new StackOverFlowWebsite(this);
        }
    }
}
