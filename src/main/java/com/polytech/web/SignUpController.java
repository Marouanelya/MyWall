package com.polytech.web;

import com.polytech.business.Authority;
import com.polytech.business.AuthorityService;
import com.polytech.business.User;
import com.polytech.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by E.Marouane on 26/03/2017.
 */

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(value = "/signup")
    public String signUpPage(){
        System.out.println("IN");
        /*userService.save(user);
        List<Users> liste = userService.fetchAll();
        for (Users u: liste) {
            System.out.println(u);
        }*/
        return "signup";
    }

    @RequestMapping(value = "/dosignup")
    public String signUp(User user){
        System.out.println("IN DO");
        System.out.println(user);
        user.setEnabled(true);
        userService.save(user);
        List<User> liste = userService.fetchAll();
        for (User u: liste) {
            System.out.println(u);
        }

        List<Authority> listeAuth = authorityService.fetchAll();
        for (Authority u: listeAuth) {
            System.out.println(u);
        }

        return "redirect:/login";
    }






}
