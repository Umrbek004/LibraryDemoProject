package com.example.librarydemoproject.dto.orderDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllApproveRequests {
    private Integer id;
    private Boolean isApproved;
    private Boolean isReturned;
    private Date orderDate;
    private Integer bookId;
    private Integer userId;
}
