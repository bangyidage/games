package com.npb.dao;

import com.npb.pojo.User;
import com.npb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    @Test
    public void getUserList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userById = userMapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void getUserByIdMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map =  new HashMap<String, Object>();
        map.put("id", 2);
        User user = userMapper.getUserByIdMap(map);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void getUserListLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserListLike("主持");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.addUser(new User(3, "孙悟空", "一棒"));
        if(res>0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void modifyUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.modifyUser(new User(1, "和平", "得到"));
        System.out.println(res);
        if(res > 0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.deleteUser(5);
        System.out.println(res);
        if(res > 0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void AddUserByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map =  new HashMap<String, Object>();
        map.put("id", 6);
        map.put("username", "人太懒");
        map.put("password", "我组");
        userMapper.addUserByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
