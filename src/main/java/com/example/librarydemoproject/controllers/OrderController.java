package com.example.librarydemoproject.controllers;

import com.example.librarydemoproject.service.OrderManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderManageService orderManageService;

    @GetMapping("book/{id}")
//    @PostMapping("book/{id}")
    public ResponseEntity<?> orderBook(@PathVariable Integer id) {
        return ResponseEntity.ok(orderManageService.order(id));
    }
}
