package com.payments.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
public class BillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "dueDate")
    private Date dueDate;

    @Column(name = "payday")
    private Date payday;

    @Column(name = "priceWithTax")
    private Double priceWithTax;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dateDue) {
        this.dueDate = dateDue;
    }

    public Date getPayday() {
        return payday;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }

    public Double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }
}
