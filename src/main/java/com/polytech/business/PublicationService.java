package com.polytech.business;

import com.polytech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
@Component
public class PublicationService {

    @Autowired
    private PostRepository postRepository;

    public PublicationService(){

    }

    public PublicationService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void post(Post post) {

        postRepository.save(post);
    }

    public List<Post> fetchAll(){
        return postRepository.findAll();
    }

    public void delete(long postID){
        postRepository.delete(postID);
    }

}
