package top.safer.springbootdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.safer.springbootdemo.model.User;

import java.util.List;

//用于标注数据库访问组件
@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET name = ? , password = ? , age = ? WHERE id=?",
                user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM users where id = ? ",id);
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findALL() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
        // return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper(User.class));
    }

}
