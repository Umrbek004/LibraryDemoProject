package com.example.librarydemoproject.controllers;

import com.example.librarydemoproject.entity.UserEntity;
import com.example.librarydemoproject.model.ResponseModel;
import com.example.librarydemoproject.service.UserManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManageService userManageService;

    @GetMapping
    public ResponseEntity<?> getAllAdmins() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserEntity user) {
        userManageService.addUser(user);
        return userManageService.addUser(user) ? ResponseEntity.ok(ResponseModel.getSuccess("added")) :
                ResponseEntity.ok(ResponseModel.getSuccess("not added"));
    }
}
