package com.example.librarydemoproject.service;

import com.example.librarydemoproject.repository.UserManageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManageService {
    private final UserManageRepository userManageRepository;
}
