package com.polytech.repository;

import com.polytech.business.Likes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by E.Marouane on 23/03/2017.
 */
@Repository
@Transactional
public class JpaLikeRepository implements LikeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public JpaLikeRepository(){

    }

    @Override
    public Likes find(long postID, String username) {
        String req = "SELECT l FROM Likes l WHERE l.postID = " + postID + " AND l.username = " + username;
        Query query = entityManager.createQuery(req);
        return (Likes) query.getSingleResult();
    }

    @Override
    public List<Likes> fetchAll(long postID) {
        String req = "SELECT l FROM Likes l WHERE l.postID = " + postID;
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    @Override
    public void save(Likes like) {
        entityManager.persist(like);
    }

    @Override
    public void delete(long postID, String username) {
        String req = "DELETE FROM Likes l WHERE l.postID = " + postID;
        Query query = entityManager.createQuery(req);
        query.executeUpdate();
    }
}
