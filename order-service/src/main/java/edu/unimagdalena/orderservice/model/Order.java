package edu.unimagdalena.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String description;
    private Double amount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate date;

    @PrePersist
    protected void onCreate(){
        this.date = LocalDate.now();
    }


}
