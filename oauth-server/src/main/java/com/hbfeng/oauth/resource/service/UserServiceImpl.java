package com.hbfeng.oauth.resource.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    public String selectPasswdByEmail(String email){
        return "email123";
    }
    public String selectPasswdByPhone(String phone){
        return "phone123";
    }
}
