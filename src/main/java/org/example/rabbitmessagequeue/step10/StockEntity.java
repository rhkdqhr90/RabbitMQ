package org.example.rabbitmessagequeue.step10;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stock;

    private boolean processed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
