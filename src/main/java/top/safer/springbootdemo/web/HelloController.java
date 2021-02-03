package top.safer.springbootdemo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sakura
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello world "+name;
    }
}
