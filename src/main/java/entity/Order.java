package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Order extends BasicEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    @Column
    private Boolean isApproved;
    @Column
    private Boolean isReturned;
    @Column(columnDefinition = "timestamp default now()")
    private Date orderDate;
}
