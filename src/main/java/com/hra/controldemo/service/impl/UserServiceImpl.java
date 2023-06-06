package com.hra.controldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hra.controldemo.mapper.UserMapper;
import com.hra.controldemo.pojo.User;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByMac(String mac) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("mac",mac));
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }
}
