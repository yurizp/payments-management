package com.payments.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
@Getter
@Setter
public class BillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @Column(name = "payday")
    private LocalDate payday;

    @Column(name = "priceWithTax")
    private Double priceWithTax;
}
