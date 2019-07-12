package com.payments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
public class RequestBillDTO {

    @JsonProperty("nome")
    @NotBlank(message = "O campo nome não pode ser nulo nem vazio.")
    private String name;

    @JsonProperty("preco")
    @NotNull(message = "O campo preco não pode ser nulo nem vazio.")
    private Double price;

    @JsonProperty("dataVencimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "O campo dataVencimento não pode ser nulo nem vazio.")
    private LocalDate dueDate;

    @JsonProperty("dataPagamento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "O campo dataPagamento não pode ser nulo nem vazio.")
    private LocalDate payday;

    private RequestBillDTO(@NotBlank(message = "O campo nome não pode ser nulo nem vazio.") String name, @NotNull(message = "O campo preco não pode ser nulo nem vazio.") Double price, @NotNull(message = "O campo dataVencimento não pode ser nulo nem vazio.") LocalDate dueDate, @NotNull(message = "O" +
            " campo dataPagamento não pode ser nulo nem vazio.") LocalDate payday) {
        this.name = name;
        this.price = price;
        this.dueDate = dueDate;
        this.payday = payday;
    }

    public RequestBillDTO() {
    }
}
