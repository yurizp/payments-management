package com.payments.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RequestBillDTO {

    @JsonProperty("nome")
    @NotBlank(message = "O campo nome não pode ser nulo nem vazio.")
    private String name;

    @JsonProperty("preco")
    @NotNull(message = "O campo preco não pode ser nulo nem vazio.")
    private Double price;

    @JsonProperty("dataVencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "O campo dataVencimento não pode ser nulo nem vazio.")
    private Date dueDate;

    @JsonProperty("dataPagamento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "O campo dataPagamento não pode ser nulo nem vazio.")
    private Date payday;

    public RequestBillDTO() {
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Date getPayday() {
        return payday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
