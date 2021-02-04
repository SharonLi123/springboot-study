package top.safer.springbootdemo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.safer.springbootdemo.enums.UserSexEnum;
import top.safer.springbootdemo.model.User;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUser()  {
        //增加
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        //删除
        int count=userMapper.delete(2l);
        User user = userMapper.getOne(1l);
        user.setNickName("smile");
        //修改
        userMapper.update(user);
        //查询
        List<User> users = userMapper.getAll();
    }
}