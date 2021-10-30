package com.bibhu.couponservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bibhu.couponservice.model.Users;
import com.bibhu.couponservice.repos.UsersRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final Users user = this.usersRepo.findByEmail(username);
        if(null == user){
            throw new UsernameNotFoundException("User not found for email : " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }
}
