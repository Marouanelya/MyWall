package com.polytech.business;

import com.polytech.repository.AuthorityRepository;
import com.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by E.Marouane on 06/04/2017.
 */
@Component
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public AuthorityService(){

    }

    public AuthorityService(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }

    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    public List<Authority> fetchAll(){
        return authorityRepository.findAll();
    }

}

