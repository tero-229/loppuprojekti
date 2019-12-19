package academy.ystavasovellus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/myprofile")
    public String myprofile() {
        return "myprofile";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/users")
    public String users () {
        return "users";
    }

    @RequestMapping(value = "/friendlist")
    public String friendlist () {
        return "friendlist";
    }

    @RequestMapping(value = "/editprofile")
    public String editprofile () {
        return "editprofile";
    }

    @RequestMapping(value = "/chat")
    public String chat () {
        return "chat";
    }

}