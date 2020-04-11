package com.hbfeng.oauth.resource.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service("myClientDetailsService")
public class MyClientDetailsService implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException{
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(clientId);
        details.setAuthorizedGrantTypes(Arrays.asList("authorization_code") );
        details.setScope(Arrays.asList("all", "read", "write"));
        details.setResourceIds(Arrays.asList("oauth2-resource"));
        details.setRegisteredRedirectUri(Collections.singleton("http://www.baidu.com"));
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        details.setAuthorities(authorities);
        return details;
    }
}
