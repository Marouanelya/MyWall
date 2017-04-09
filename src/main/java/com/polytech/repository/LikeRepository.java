package com.polytech.repository;

import com.polytech.business.Likes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by E.Marouane on 23/03/2017.
 */
@Repository
public interface LikeRepository {
    Likes find(long postID, String username);
    List<Likes> fetchAll(long postID);
    void save(Likes like);
    void delete(long postID, String username);
}
