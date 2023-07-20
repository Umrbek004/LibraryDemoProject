package com.example.librarydemoproject.controllers;

import com.example.librarydemoproject.dto.BookUpdateDTO;
import com.example.librarydemoproject.entity.BookEntity;
import com.example.librarydemoproject.model.ResponseModel;
import com.example.librarydemoproject.service.BookManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookManageService bookManageService;

    @GetMapping(value = {"", "{page}"})
    public ResponseEntity<?> getAllBooks(@PathVariable(required = false) Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit,
                                         @RequestParam(required = false, defaultValue = "title") String sortBy,
                                         @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        List<BookEntity> allBooksByLimit = bookManageService.getAllBooksByLimit(page, limit, sortBy, sortOrder);
        return ResponseEntity.ok(ResponseModel.getSuccess(allBooksByLimit));
    }

    @PostMapping
    public ResponseEntity<?> searchBook(@RequestParam String word, @RequestParam(required = false, defaultValue = "true") String searchByTitle) {
        return ResponseEntity.ok(ResponseModel.getSuccess(bookManageService.searchBookByWord(word, searchByTitle)));
    }

    @PostMapping("add")
    public ResponseEntity<?> addBook(@RequestBody BookEntity book) {
        return bookManageService.addBook(book) ? ResponseEntity.ok(ResponseModel.getSuccess("added")) :
                ResponseEntity.ok(ResponseModel.getSuccess("not added"));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateBook(@RequestBody BookUpdateDTO bookUpdateDTO) {
        return bookManageService.updateBook(bookUpdateDTO) ? ResponseEntity.ok(ResponseModel.getSuccess("updated")) :
                ResponseEntity.ok(ResponseModel.getSuccess("not updated"));
    }

}
