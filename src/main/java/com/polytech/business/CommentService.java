package com.polytech.business;

import com.polytech.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by E.Marouane on 20/03/2017.
 */

@Component
public class CommentService
{

    @Autowired
    private CommentRepository commentRepository;

    public CommentService(){

    }

    public  CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void comment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> fetchAll(long postID){
        return commentRepository.findAll(postID);
    }

    public void delete(long id){
        commentRepository.delete(id);
    }

}
