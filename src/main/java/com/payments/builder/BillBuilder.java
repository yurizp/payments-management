package com.payments.builder;

import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import org.springframework.stereotype.Component;

@Component
public class BillBuilder {

    public ResponseBillDTO createInstance(RequestBillDTO requestBillDTO) {
        return ResponseBillDTO.builder()
                .name(requestBillDTO.getName())
                .dateDue(requestBillDTO.getDueDate())
                .payday(requestBillDTO.getPayday())
                .price(requestBillDTO.getPrice())
                .build();
    }

    public ResponseBillDTO createInstance(BillModel billModel) {
        return ResponseBillDTO.builder()
                .name(billModel.getName())
                .dateDue(billModel.getDueDate())
                .payday(billModel.getPayday())
                .priceWithTax(billModel.getPriceWithTax())
                .price(billModel.getPrice())
                .build();
    }

}
