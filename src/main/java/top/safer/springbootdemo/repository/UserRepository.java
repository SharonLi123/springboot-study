package top.safer.springbootdemo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import top.safer.springbootdemo.model.User;

import java.util.List;

public interface UserRepository {
    int save(User user);
    int save(User user, JdbcTemplate jdbcTemplate);
    int update(User user);
    int delete(long id);
    List<User> findALL();
    User findById(long id);
}
