package com.example.librarydemoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderEntity extends BasicEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity book;
    @Column
    private Boolean isApproved;
    @Column
    private Boolean isReturned;
    @Column
    private Date orderDate= new Date();
}
