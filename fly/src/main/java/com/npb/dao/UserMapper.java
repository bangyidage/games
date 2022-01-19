package com.npb.dao;

import com.npb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取全部用户
    List<User> getUserList();
    List<User> getUserListLike(String username);
    User getUserById(int id);

    User getUserByIdMap(Map<String, Object> map);

    int addUser(User user);

    int modifyUser(User user);

    int deleteUser(int id);

    int addUserByMap(Map<String, Object> map);
}
