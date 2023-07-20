package com.example.librarydemoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookEntity extends BasicEntity {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    private String description;
    @Column
    private Integer quantity;
    @Column
    private Integer cost;

    public BookEntity(Integer id, String title, String authorName, String description, Integer quantity, Integer cost) {
        setId(id);
        setTitle(title);
        setAuthorName(authorName);
        setDescription(description);
        setQuantity(quantity);
        setCost(cost);
    }
}
