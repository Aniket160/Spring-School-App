package com.EazySchool1.EazySchoolSite1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping(value={"","/","/home"})
    public String displayHomePage()
    {
        return "home.html";
    }

    @RequestMapping("/courses")
    public String displayHomePage1(){return "courses.html";}
        @RequestMapping("/about")
        public String displayHomePage2(){return "about.html";}

}
