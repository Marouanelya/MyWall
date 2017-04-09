package com.polytech.repository;

import com.polytech.business.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 * Created by E.Marouane on 06/04/2017.
 */
@Repository
@Transactional
public class JpaUserRepository implements  UserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public JpaUserRepository(){

    }

    @Override
    public List<User> findAll() {
        String req = "SELECT u FROM User u";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
