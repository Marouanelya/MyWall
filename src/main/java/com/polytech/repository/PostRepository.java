package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
@Repository
public interface PostRepository{
    List<Post> findAll();
    void save(Post post);
    void delete(long postID);
}
