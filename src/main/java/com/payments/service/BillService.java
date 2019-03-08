package com.payments.service;

import com.payments.builder.BillBuilder;
import com.payments.builder.BillModelBuilder;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import com.payments.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    private BillRepository billRepository;
    private BillBuilder builderResponse;
    private BillModelBuilder builderModel;
    private CalculateBillService calculateBillService;

    @Autowired
    public BillService(BillRepository billRepository, BillBuilder builderResponse, BillModelBuilder builderModel, CalculateBillService calculateBillService) {
        this.billRepository = billRepository;
        this.builderResponse = builderResponse;
        this.builderModel = builderModel;
        this.calculateBillService = calculateBillService;
    }

    public ResponseBillDTO create(ResponseBillDTO billDTO) {
        billDTO = calculateBillService.calculateWithTax(billDTO);
        BillModel billModel = builderModel.createInstance(billDTO);
        billModel = billRepository.save(billModel);
        return builderResponse.createInstance(billModel);

    }

    public List<ResponseBillDTO> getBills() {
        List<BillModel> billModels = new ArrayList<>();
        billRepository.findAll().forEach(billModels::add);
        return billModels.stream().map(builderResponse::createInstance).collect(Collectors.toList());
    }
}
