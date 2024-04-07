package dev.otthon.dynamicpricing.service;

import dev.otthon.dynamicpricing.domain.SocialMetaTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SocialMetaTagService {

    private static Logger Log = LoggerFactory.getLogger(SocialMetaTagService.class);

    // Verifica se as tags dos metadados estão nulas
    public SocialMetaTag getSocialMetaTagByUrl(String url) {
        SocialMetaTag twitter = getTwitterCardByUrl(url);
        if (!isEmpty(twitter)) {
            return twitter;
        }

        SocialMetaTag openGraph = getOpenGraphByUrl(url);
        if (!isEmpty(openGraph)) {
            return openGraph;
        }
        return null;
    }

    private SocialMetaTag getTwitterCardByUrl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).get();
            tag.setTitle(doc.head().select("meta[property=twitter:title]").attr("content"));
            tag.setUrl(doc.head().select("meta[name=twitter:url]").attr("content"));
            tag.setImage(doc.head().select("meta[name=twitter:image]").attr("content"));
            tag.setSite(doc.head().select("meta[name=twitter:site]").attr("content"));
        } catch (IOException e) {
            Log.error(e.getMessage(), e.getCause());
        }
        return tag;
    }

    private SocialMetaTag getOpenGraphByUrl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).header("Access-Control-Allow-Origin", "https://collector-pxzhh9f9x0.perimeterx.net/api/v1/collector").get();
            tag.setTitle(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setUrl(doc.head().select("meta[property=og:url]").attr("content"));
            tag.setImage(doc.head().select("meta[property=og:image]").attr("content"));
            tag.setSite(doc.head().select("meta[property=og:site_name]").attr("content"));
        } catch (IOException e) {
            Log.error(e.getMessage(), e.getCause());
        }
        return tag;
    }

    // Verifica se se alguma das tags do metadados do site está vazia
    private boolean isEmpty(SocialMetaTag tag) {
        if (tag.getImage().isEmpty()) return true;
        if (tag.getSite().isEmpty()) return true;
        if (tag.getTitle().isEmpty()) return true;
        if (tag.getUrl().isEmpty()) return true;
        return false;
    }

}
