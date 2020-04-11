package com.hbfeng.oauth.resource.config;

import com.hbfeng.oauth.resource.ResourceApplication;
import com.hbfeng.oauth.resource.handler.LoginInSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {
    private static final String URL = "http://localhost:8080/oauth/check_token";

//    @Autowired
//    LoginInSuccessHandler LoginInSuccessHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(URL);
        tokenService.setClientId("client");
        tokenService.setClientSecret("secret");
        resources.tokenServices(tokenService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .oauth2Login().successHandler(LoginInSuccessHandler)
//                .and()
                .authorizeRequests()
                .antMatchers("/user/*").authenticated()
                .anyRequest().permitAll()
                .and()
                //关闭跨站请求防护
                .csrf().disable();
    }
}