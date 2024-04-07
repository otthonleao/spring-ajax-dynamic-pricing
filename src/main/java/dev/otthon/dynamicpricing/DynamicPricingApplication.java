package dev.otthon.dynamicpricing;

import dev.otthon.dynamicpricing.domain.SocialMetaTag;
import dev.otthon.dynamicpricing.service.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicPricingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DynamicPricingApplication.class, args);
    }

    @Autowired
    SocialMetaTagService service;

    @Override
    public void run(String... args) throws Exception {
//        SocialMetaTag tag = service.getSocialMetaTagByUrl("https://www.mobly.com.br/mesa-de-escritorio-ipiranga-off-white-e-amendoa-716850.html?origin=jetmobly&label=");
//        System.out.println(tag.toString());
    }
}
