package com.lkspringsecurity.dmeo1.service;

import com.lkspringsecurity.dmeo1.domain.SecurityUser;
import com.lkspringsecurity.dmeo1.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("自主查询");

        User user = new User();
        user.setPassword("admin");
        user.setUsername("admin");
        user.setToken("ceshi_admin");
        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;
    }
}
