package kr.ac.kuh.hellospring.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("data", "spring 개발자님!");
        return "hello";
    }

    @RequestMapping(value = "/hello-mvc", method = RequestMethod.GET)
    public String helloMVC(@RequestParam(value = "name") String name,
        Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @RequestMapping(value = "/hello-mvc2", method = RequestMethod.GET)
    public String helloMVC2(@RequestParam(value = "name") String name,
        Model model) {
        model.addAttribute("name", name);
        return "hello-template2";
    }

    @RequestMapping(value = "/hello-string", method = RequestMethod.GET)
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello " + name + "님!";
    }

    @RequestMapping(value = "/hello-api", method = RequestMethod.GET)
    @ResponseBody
    public User helloAPI(@RequestParam(value = "name") String name) {
        //return "hello " + name + "님!";
        User user = new User(name, 30);
        //user.setName("김태희");
        //user.setAge(30);
        return user;
    }


    @AllArgsConstructor
    @Data
    static class User {

        private String name;

        private int age;
    }
}
