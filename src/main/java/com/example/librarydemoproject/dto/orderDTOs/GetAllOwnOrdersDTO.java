package com.example.librarydemoproject.dto.orderDTOs;

import com.example.librarydemoproject.entity.BookEntity;
import com.example.librarydemoproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOwnOrdersDTO {

    private UserEntity user;
    private BookEntity book;
    private Boolean isApproved;
    private Boolean isReturned;
    private Date orderDate;
}
