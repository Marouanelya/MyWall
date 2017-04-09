package com.polytech.repository;

import com.polytech.business.Authority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by E.Marouane on 06/04/2017.
 */
@Repository
@Transactional
public class JpaAuthorityRepository implements  AuthorityRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public JpaAuthorityRepository(){

    }

    @Override
    public List<Authority> findAll() {
        String req = "SELECT a FROM Authority a";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    @Override
    public void save(Authority authority) {
        entityManager.persist(authority);
    }
}
