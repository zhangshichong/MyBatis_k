package com.zhang.dao;

import com.zhang.utils.MybatisUtils;
import com.zhang.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步 、获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：getMapper
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void selectById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user.toString());
        sqlSession.close();
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.addUser(new User(6, "hhh", "1243354"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(4, "shabi", "000000"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
