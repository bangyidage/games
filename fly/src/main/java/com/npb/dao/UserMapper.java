package com.npb.dao;

import com.npb.pojo.User;

import java.util.List;

public interface UserMapper {
    // 获取全部用户
    List<User> getUserList();

    User getUserById(int id);
    int addUser(User user);
    int modifyUser(User user);
    int deleteUser(int id);
}
