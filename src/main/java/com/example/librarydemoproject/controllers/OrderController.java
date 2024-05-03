package com.example.librarydemoproject.controllers;

import com.example.librarydemoproject.model.ResponseModel;
import com.example.librarydemoproject.service.OrderManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderManageService orderManageService;

    //    @GetMapping("book/{id}")
    @PostMapping("book/{id}")
    public ResponseEntity<?> orderBook(@PathVariable Integer id) {
        return ResponseEntity.ok(orderManageService.order(id));
    }

    @GetMapping("allOwnOrders")
    public ResponseEntity<?> getAllOwnOrders() {
        return ResponseEntity.ok(ResponseModel.getSuccess(orderManageService.getAllOwnOrders()));
    }

    @GetMapping("approveRequests")
    public ResponseEntity<?> getAllApproveRequests(){
        return ResponseEntity.ok(ResponseModel.getSuccess(orderManageService.getAllApproveRequests()));
    }
}
