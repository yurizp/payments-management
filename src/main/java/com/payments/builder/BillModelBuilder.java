package com.payments.builder;

import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import org.springframework.stereotype.Component;

@Component
public class BillModelBuilder {

    public BillModel createInstance(ResponseBillDTO billDTO) {
        BillModel billModel = new BillModel();
        billModel.setName(billDTO.getName());
        billModel.setDueDate(billDTO.getDateDue());
        billModel.setPayday(billDTO.getPayday());
        billModel.setPrice(billDTO.getPrice());
        billModel.setPriceWithTax(billDTO.getPriceWithTax());
        return billModel;
    }
}
