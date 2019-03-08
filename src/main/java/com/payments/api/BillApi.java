package com.payments.api;

import com.payments.adapter.BillAdapter;
import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/bill")
public class BillApi {

    private BillAdapter billAdapter;

    @Autowired
    public BillApi(BillAdapter billAdapter) {
        this.billAdapter = billAdapter;
    }


    @PostMapping
    public ResponseEntity<ResponseBillDTO> insertBill(@Valid @RequestBody RequestBillDTO requestBillDTO) {
        ResponseBillDTO response = billAdapter.crateBill(requestBillDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponseBillDTO>> getListBill(){
        List<ResponseBillDTO> allBills = billAdapter.getAllBills();
        return ResponseEntity.ok(allBills);
    }
}
