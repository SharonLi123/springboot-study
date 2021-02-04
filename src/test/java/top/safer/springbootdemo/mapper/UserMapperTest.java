package top.safer.springbootdemo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.safer.springbootdemo.enums.UserSexEnum;
import top.safer.springbootdemo.mapper.one.User1Mapper;
import top.safer.springbootdemo.mapper.two.User2Mapper;
import top.safer.springbootdemo.model.User;
import top.safer.springbootdemo.param.UserParam;
import top.safer.springbootdemo.result.Page;

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

    @Test
    public void testPage() {
        UserParam userParam=new UserParam();
        userParam.setUserSex("MAN");
        userParam.setCurrentPage(0);
        System.out.println(userParam.getBeginLine());
        List<User> users=userMapper.getList(userParam);
        System.out.println(users);
        long count=userMapper.getCount(userParam);
        System.out.println(count);
        Page page = new Page(userParam,count,users);
        System.out.println(page);
    }

    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void testInsert() throws Exception {
        user1Mapper.insert(new User("aa111", "a123456", UserSexEnum.MAN));
        user1Mapper.insert(new User("bb111", "b123456", UserSexEnum.WOMAN));
        user2Mapper.insert(new User("cc222", "b123456", UserSexEnum.MAN));
    }
}