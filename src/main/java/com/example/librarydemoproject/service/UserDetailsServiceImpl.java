package com.example.librarydemoproject.service;

import com.example.librarydemoproject.entity.UserEntity;
import com.example.librarydemoproject.repository.UserManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserManageRepository userManageRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity byUsername = userManageRepository.findByUsername(username);
        return new AppUser(byUsername.getUsername(), byUsername.getPassword(), byUsername.getUserRole());
    }
}
