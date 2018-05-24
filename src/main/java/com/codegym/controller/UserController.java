package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("home", "login", new Login());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login ){
        User user = UserDao.checkLogin(login);
        if(user == null) {
            ModelAndView mav = new ModelAndView("error");
            return mav;
        }else {
            ModelAndView mav = new ModelAndView("user");
            mav.addObject("user", user);
            return mav;
        }
    }
}
