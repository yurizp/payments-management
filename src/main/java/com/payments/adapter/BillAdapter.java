package com.payments.adapter;

import com.payments.builder.BillBuilder;
import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillAdapter {

    private BillBuilder billBuilder;
    private BillService billService;

    @Autowired
    public BillAdapter(BillBuilder billBuilder, BillService billService) {
        this.billBuilder = billBuilder;
        this.billService = billService;
    }

    public ResponseBillDTO crateBill(RequestBillDTO requestBillDTO) {
        return billService.create(billBuilder.createInstance(requestBillDTO));
    }

    public List<ResponseBillDTO> getAllBills() {
        return billService.getBills();
    }
}
