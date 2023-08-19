package kr.ac.kuh.hellospring.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @RequestMapping(value = "/hello-api", method = RequestMethod.GET)
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
