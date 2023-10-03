package com.example.librarydemoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderEntity extends BasicEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id",nullable = false)
    private BookEntity book;
    @Column
    private Boolean isApproved;
    @Column
    private Boolean isReturned;
    @Column
    private Date orderDate = new Date();
}
