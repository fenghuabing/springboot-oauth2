package com.hbfeng.oauth.resource.service;

import com.hbfeng.oauth.resource.util.CheckFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String passwd = "";
        if (CheckFormat.isEmail(username)){
            passwd = userService.selectPasswdByEmail(username);
        }else if (CheckFormat.isPhone(username)){
            passwd = userService.selectPasswdByPhone(username);
        }else {
            passwd = "123";
        }
        passwd = passwordEncoder.encode(passwd);
        return new User(username, passwd, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}