package com.hbfeng.oauth.resource.service;

public interface UserService {
    String selectPasswdByEmail(String email);
    String selectPasswdByPhone(String phone);
}
