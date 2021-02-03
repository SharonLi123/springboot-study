package top.safer.springbootdemo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.safer.springbootdemo.model.User;

/**
 * @author sakura
 */
@RestController
public class WebController {

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public User getUser(){
        User user=new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }

    /**
     * 使用url进行传参
     * @param name
     * @return
     */
    @RequestMapping(value = "get/{name}",method = RequestMethod.GET)
    public String get(@PathVariable String name){
        return name;
    }
}
