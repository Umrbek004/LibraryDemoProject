package com.example.librarydemoproject.repository;

import com.example.librarydemoproject.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookManageRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findAllByOrderByTitleAsc(Pageable pageable);

    List<BookEntity> findAllByOrderByTitleDesc(Pageable pageable);

    List<BookEntity> findAllByOrderByCostAsc(Pageable pageable);

    List<BookEntity> findAllByOrderByCostDesc(Pageable pageable);

    List<BookEntity> findAllByOrderByQuantityAsc(Pageable pageable);

    List<BookEntity> findAllByOrderByQuantityDesc(Pageable pageable);

    List<BookEntity> findAllByOrderByAuthorNameAsc(Pageable pageable);

    List<BookEntity> findAllByOrderByAuthorNameDesc(Pageable pageable);


    List<BookEntity> findAllByTitleLikeIgnoreCaseOrderByTitle(String word);

    List<BookEntity> findAllByAuthorNameLikeIgnoreCaseOrderByAuthorName(String word);

}
