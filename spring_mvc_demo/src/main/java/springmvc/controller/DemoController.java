package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springmvc.pojo.User;

@RestController
public class DemoController {

    @GetMapping("/user")
    @ResponseBody
    public User testResponseBody(){
        User user = new User(1001,"admin","123456");
        return user;
    }


    /*@RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
                           String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId:" + jsessionId);
        System.out.println("username:" + username + ",password:" + password);
        System.out.println("referer:" + referer);
        return "success";
    }*/

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "userName",required = false,defaultValue = "hello")
                                       String username, String password){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @PostMapping("/testPostMapping")
    public String testPostMapping(String username,String password){
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }




}
