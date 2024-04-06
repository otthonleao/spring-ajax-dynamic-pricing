package dev.otthon.dynamicpricing.domain;

import java.io.Serializable;

@SuppressWarnings("Serial")
public class SocialMetaTag implements Serializable {
    private String site;
    private String tirle;
    private String url;
    private String image;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTirle() {
        return tirle;
    }

    public void setTirle(String tirle) {
        this.tirle = tirle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
