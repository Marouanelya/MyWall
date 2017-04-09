package com.polytech.repository;

import com.polytech.business.Authority;
import com.polytech.business.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by E.Marouane on 06/04/2017.
 */
@Repository
public interface AuthorityRepository {
    List<Authority> findAll();
    void save(Authority authority);
}
