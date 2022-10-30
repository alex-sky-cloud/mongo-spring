package com.spring.mongo.service.dto.stackexchange;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SiteDto {

    @JsonProperty("favicon_url")
    String faviconUrl;

    String audience;


    @JsonProperty("site_url")
    String siteUrl;

    String name;

    public SiteDto() {
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
        SiteDto siteDto = (SiteDto) o;
        return Objects.equals(faviconUrl, siteDto.faviconUrl) &&
                Objects.equals(audience, siteDto.audience) &&
                Objects.equals(siteUrl, siteDto.siteUrl) &&
                Objects.equals(name, siteDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faviconUrl, audience, siteUrl, name);
    }

    @Override
    public String toString() {
        return "SiteDto{" +
                "faviconUrl='" + faviconUrl + '\'' +
                ", audience='" + audience + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
