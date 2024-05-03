package com.example.librarydemoproject.repository;

import com.example.librarydemoproject.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderManageRepository extends CrudRepository<OrderEntity, Integer> {

    @Query(value = "insert into order_entity(is_approved,is_returned,order_date,book_id,user_id) values(false,false,now(),:book_id,:user_id) returning id;",
            nativeQuery = true)
    Integer saveOrderEntityRequest(@Param("book_id") Integer book_id, @Param("user_id") Integer user_id);

    List<OrderEntity> findAllByUserId(Integer id);

    List<OrderEntity> findAllByIsApprovedFalse();
}
