package com.payments.builder;

import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import org.springframework.stereotype.Component;

@Component
public class BillBuilder {

    public ResponseBillDTO createInstance(RequestBillDTO requestBillDTO) {
        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setName(requestBillDTO.getName());
        responseBillDTO.setDateDue(requestBillDTO.getDueDate());
        responseBillDTO.setPayday(requestBillDTO.getPayday());
        responseBillDTO.setPrice(requestBillDTO.getPrice());
        return responseBillDTO;
    }

    public ResponseBillDTO createInstance(BillModel billModel) {
        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setName(billModel.getName());
        responseBillDTO.setDateDue(billModel.getDueDate());
        responseBillDTO.setPayday(billModel.getPayday());
        responseBillDTO.setPrice(billModel.getPrice());
        responseBillDTO.setPriceWithTax(billModel.getPriceWithTax());
        return responseBillDTO;
    }

}
