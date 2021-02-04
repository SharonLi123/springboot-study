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
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user) {
        return primaryJdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge());
    }

    /**
     * 多数据源测试
     * @param user
     * @param jdbcTemplate
     * @return
     */
    @Override
    public int save(User user, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= primaryJdbcTemplate;
        }
        return jdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge());
    }

    @Override
    public int update(User user) {
        return primaryJdbcTemplate.update("UPDATE users SET name = ? , password = ? , age = ? WHERE id=?",
                user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return primaryJdbcTemplate.update("DELETE FROM users where id = ? ",id);
    }

    @Override
    public User findById(long id) {
        return primaryJdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findALL() {
        return primaryJdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
        // return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper(User.class));
    }

}
