package com.example.librarydemoproject.service;

import com.example.librarydemoproject.dto.BookUpdateDTO;
import com.example.librarydemoproject.entity.BookEntity;
import com.example.librarydemoproject.repository.BookManageRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookManageService {
    private final BookManageRepository bookManageRepository;

    public List<BookEntity> getAllBooksByLimit(Integer page, Integer limit, String sortBy, String sortOrder) {
        List<BookEntity> resultList;
        if (sortOrder.equals("asc")) {
            switch (sortBy) {
                case "title":
                    Pageable pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("title").ascending());
                    resultList = bookManageRepository.findAllByOrderByTitleAsc(pageable);
                    break;
                case "cost":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("cost").ascending());
                    resultList = bookManageRepository.findAllByOrderByCostAsc(pageable);
                    break;
                case "quantity":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("quantity").ascending());
                    resultList = bookManageRepository.findAllByOrderByQuantityAsc(pageable);
                    break;
                case "authorName":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("authorName").ascending());
                    resultList = bookManageRepository.findAllByOrderByAuthorNameAsc(pageable);
                    break;
                default:
                    return null;
            }
        } else {
            switch (sortBy) {
                case "title":
                    Pageable pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("title").descending());
                    resultList = bookManageRepository.findAllByOrderByTitleDesc(pageable);
                    break;
                case "cost":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("cost").descending());
                    resultList = bookManageRepository.findAllByOrderByCostDesc(pageable);
                    break;
                case "quantity":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("quantity").descending());
                    resultList = bookManageRepository.findAllByOrderByQuantityDesc(pageable);
                    break;
                case "authorName":
                    pageable = PageRequest.of(page == null ? 0 : page, limit, Sort.by("authorName").descending());
                    resultList = bookManageRepository.findAllByOrderByAuthorNameDesc(pageable);
                    break;
                default:
                    return null;
            }
        }
        return resultList;
    }

    public List<BookEntity> searchBookByWord(String word, String searchByTitle) {
        return searchByTitle.equals("true") ? bookManageRepository.findAllByTitleLikeIgnoreCaseOrderByTitle("%" + word + "%") :
                bookManageRepository.findAllByAuthorNameLikeIgnoreCaseOrderByAuthorName("%" + word + "%");
    }

    public boolean addBook(BookEntity book) {
        try {
            bookManageRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateBook(BookUpdateDTO bookUpdateDTO) {
        try {
            bookManageRepository.save(new BookEntity(bookUpdateDTO.getId(), bookUpdateDTO.getTitle(), bookUpdateDTO.getAuthorName(),
                    bookUpdateDTO.getDescription(), bookUpdateDTO.getQuantity(), bookUpdateDTO.getCost()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
