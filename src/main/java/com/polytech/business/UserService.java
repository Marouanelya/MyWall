package com.polytech.business;

import com.polytech.repository.AuthorityRepository;
import com.polytech.repository.PostRepository;
import com.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by E.Marouane on 06/04/2017.
 */

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public UserService(){

    }

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public void save(User user) {
        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), "USER"));
    }

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

}
