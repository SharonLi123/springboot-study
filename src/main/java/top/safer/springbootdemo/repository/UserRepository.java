package top.safer.springbootdemo.repository;

import top.safer.springbootdemo.model.User;

import java.util.List;

public interface UserRepository {
    int save(User user);
    int update(User user);
    int delete(long id);
    List<User> findALL();
    User findById(long id);
}
