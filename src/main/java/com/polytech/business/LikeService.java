package com.polytech.business;

import com.polytech.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by E.Marouane on 23/03/2017.
 */

@Component
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public LikeService(){

    }

    public  LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    public void like(Likes likes){
        likeRepository.save(likes);
    }

    public Likes fetch(long postID, String username){
        return likeRepository.find(postID, username);
    }

    public void delete(long postID, String username){
        likeRepository.delete(postID, username);
    }

    public List<Likes> fetchAll(int postID) {
        return likeRepository.fetchAll(postID);
    }
}
