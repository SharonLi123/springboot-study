package top.safer.springbootdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.safer.springbootdemo.model.User;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User user =new User("neo","123456",30);
        userRepository.save(user);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findALL() {
    }

    @Test
    public void findById() {
    }
}