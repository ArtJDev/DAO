package ru.netology.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    protected CustomersEntity customersEntity;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private double amount;
}