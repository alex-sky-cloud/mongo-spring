package com.spring.mongo.dao.model.sites;

import java.util.Objects;

public class SiteEntity {

    String faviconUrl;

    String audience;

    String siteUrl;

    String name;

    public SiteEntity() {
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteEntity that = (SiteEntity) o;
        return Objects.equals(faviconUrl, that.faviconUrl) &&
                Objects.equals(audience, that.audience) &&
                Objects.equals(siteUrl, that.siteUrl) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faviconUrl, audience, siteUrl, name);
    }

    @Override
    public String toString() {
        return "SiteEntity{" +
                "faviconUrl='" + faviconUrl + '\'' +
                ", audience='" + audience + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
