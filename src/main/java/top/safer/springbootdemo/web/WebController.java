package top.safer.springbootdemo.web;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.safer.springbootdemo.model.User;

import javax.validation.Valid;
import java.util.List;

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

    /**
     * 校验参数
     * @param user
     * @param result
     */
    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:"+user);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
    }
}
