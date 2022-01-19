package com.npb.dao;

import com.npb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();
    List<User> getUserByLimit(Map<String, Integer> map);
}
