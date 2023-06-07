package com.example.librarydemoproject.repository;

import com.example.librarydemoproject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManageRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
}
