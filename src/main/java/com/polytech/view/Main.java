package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.config.ApplicationConfig;
import com.polytech.repository.PostRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dev on 3/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "PROD");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PublicationService publicationService = applicationContext.getBean(PublicationService.class);

        /*Post post = new Post("Luminy est cool");
        Post post1 = new Post("Etoil");
        Post post2 = new Post("Test");
        publicationService.post(post);
        publicationService.post(post1);
        publicationService.post(post2);*/

        System.out.println(publicationService.fetchAll());
    }
}
