package com.payments.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@Getter
public class ResponseBillDTO {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("preco")
    private Double price;

    @JsonProperty("dataVencimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateDue;

    @JsonProperty("dataPagamento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate payday;

    @JsonProperty("valorCorrigido")
    private Double priceWithTax;

}
