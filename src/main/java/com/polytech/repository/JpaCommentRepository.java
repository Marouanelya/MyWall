package com.polytech.repository;

import com.polytech.business.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by E.Marouane on 20/03/2017.
 */

@Repository
@Transactional
public class JpaCommentRepository implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaCommentRepository(){

    }

    public List<Comment> findAll(long postID) {
        String req = "SELECT c FROM Comment c WHERE c.postID = " + postID;
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    public void delete(long id){
        String req2 = "DELETE FROM Comment c WHERE c.id = " + id;
        Query query2 = entityManager.createQuery(req2);
        query2.executeUpdate();
    }
}
