package com.security.service;

import com.mysql.cj.util.StringUtils;
import com.security.dao.UserMapper;
import com.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Component("userService")
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    private GrantedAuthority DEFAULT_ROLE = new SimpleGrantedAuthority("USER");


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectUserByName(username);
        if (user==null){
            throw new UsernameNotFoundException("nou found username " + username + " in db");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        String roles = user.getRole();
        if(StringUtils.isNullOrEmpty(roles)){
            grantedAuthorities.add(DEFAULT_ROLE);
        }else{
            String[] rol = roles.split(",");
            for(String r : rol){
                GrantedAuthority tempGranted = new SimpleGrantedAuthority(r);
                grantedAuthorities.add(tempGranted);
            }
        }
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
    }
}
