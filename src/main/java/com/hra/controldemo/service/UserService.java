package com.hra.controldemo.service;

import com.hra.controldemo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int saveUser(User hc);

    User getUser(Long id);

    User getUserBySid(String mac);

    int updateUser(User User);

    int deleteUser(Long id);

}
