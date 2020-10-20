package com.wyclass.controller;

import com.wyclass.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public class IndexController {

    @GetMapping("/")
    public ModelAndView index(HttpSession session)
    {
        User user =(User) session.getAttribute("user");
        return  new ModelAndView("/index.html","user",user);
    }

    @GetMapping("/hello")
     public ModelAndView hello(String name)
     {
         if(name==null)
         {
             name="world";

         }

         return new ModelAndView("/hello.html","name",name);
     }

}

