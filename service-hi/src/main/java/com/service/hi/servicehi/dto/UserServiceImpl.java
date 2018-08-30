package com.service.hi.servicehi.dto;

import com.service.hi.servicehi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;

    @Override
    public User create(String username, String password) {

//        String hash = encoder.encode(password);
//        user.setPassword(hash);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User u = userDao.save(user);
        return u;
    }
}