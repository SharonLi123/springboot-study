package top.safer.springbootdemo.mapper.two;

import top.safer.springbootdemo.model.User;
import top.safer.springbootdemo.param.UserParam;

import java.util.List;

public interface User2Mapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    int delete(Long id);

    List<User> getList(UserParam userParam);

    int getCount(UserParam userParam);
}
