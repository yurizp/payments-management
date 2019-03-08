package com.payments.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ResponseBillDTO {
    @JsonProperty("nome")
    private String name;

    @JsonProperty("preco")
    private Double price;

    @JsonProperty("dataVencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateDue;

    @JsonProperty("dataPagamento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date payday;

    @JsonProperty("valorCorrigido")
    private Double priceWithTax;

    public ResponseBillDTO() {
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

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
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
