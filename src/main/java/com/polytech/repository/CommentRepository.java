package com.polytech.repository;

import com.polytech.business.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by E.Marouane on 20/03/2017.
 */
@Repository
public interface CommentRepository {
    List<Comment> findAll(long postID);
    void save(Comment comment);
    void delete(long id);
}
