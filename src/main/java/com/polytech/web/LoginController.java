package com.polytech.web;

import com.polytech.business.PublicationService;
import com.polytech.business.User;
import com.polytech.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by E.Marouane on 17/03/2017.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
