package com.example.librarydemoproject.service;

import com.example.librarydemoproject.entity.UserEntity;
import com.example.librarydemoproject.repository.UserManageRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManageService {
    private final UserManageRepository userManageRepository;

    public boolean addUser(UserEntity user) {
        try {
            userManageRepository.save(new UserEntity(user.getUsername(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()), user.getUserRole(),
                    user.getFirstName(), user.getLastName(), user.getPhoneNumber(), 0));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
