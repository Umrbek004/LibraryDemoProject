package com.example.librarydemoproject.service;

import com.example.librarydemoproject.dto.orderDTOs.BookAndOrderPropertiesDTO;
import com.example.librarydemoproject.dto.orderDTOs.ResponseGetAllOwnOrdersDTO;
import com.example.librarydemoproject.entity.BookEntity;
import com.example.librarydemoproject.entity.OrderEntity;
import com.example.librarydemoproject.entity.UserEntity;
import com.example.librarydemoproject.repository.BookManageRepository;
import com.example.librarydemoproject.repository.OrderManageRepository;
import com.example.librarydemoproject.repository.UserManageRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderManageService {
    private final OrderManageRepository orderManageRepository;
    private final BookManageRepository bookManageRepository;
    private final UserManageRepository userManageRepository;

    public String order(Integer bookId) {
        Optional<BookEntity> byId = bookManageRepository.findById(bookId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity byUsername = userManageRepository.findByUsername(((AppUser) authentication.getPrincipal()).getUsername());
        if (byUsername.getPenalty() > 5) {
            return "You have more than 5 penalty, you cannot order book\n The penalty will disappear after some time";
        } else {
            if (byId.isPresent()) {
                BookEntity bookEntity = byId.get();
                if (bookEntity.getQuantity() < 1) {
                    return "No book left";
                } else {
                    try {
                        orderManageRepository.saveOrderEntityRequest(bookId, byUsername.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "Everything is fine";
                }
            }
        }
        return "There is no such book id =" + bookId;
    }

    public ResponseGetAllOwnOrdersDTO getAllOwnOrders() {
        LinkedList<BookAndOrderPropertiesDTO> orderEntities1 = new LinkedList<>();
        AppUser principal = (AppUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        List<OrderEntity> allByUserId = orderManageRepository.findAllByUserId(principal.getId());
        for (OrderEntity orderEntity : allByUserId) {
            orderEntities1.add(new BookAndOrderPropertiesDTO(orderEntity.getBook(),
                    orderEntity.getIsApproved(),
                    orderEntity.getIsReturned(),
                    orderEntity.getOrderDate()));
        }
        ResponseGetAllOwnOrdersDTO responseGetAllOwnOrdersDTO = new ResponseGetAllOwnOrdersDTO(allByUserId.get(0).getUser().getUsername(),
                allByUserId.get(0).getUser().getFirstName(),
                allByUserId.get(0).getUser().getLastName(),
                orderEntities1);

        return responseGetAllOwnOrdersDTO;
    }
}
