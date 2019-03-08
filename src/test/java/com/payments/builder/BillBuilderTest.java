package com.payments.builder;

import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BillBuilderTest {

    @InjectMocks
    private BillBuilder billModelBuilder;

    private String DATE_FORMAT = "dd-MM-yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    @Test
    public void shouldReturnValidResponseBillWhenSendRequestBillValid() throws ParseException {

        RequestBillDTO requestBillDTO = new RequestBillDTO();
        requestBillDTO.setPrice(200D);
        requestBillDTO.setPayday(sdf.parse("12-11-2000"));
        requestBillDTO.setDueDate(sdf.parse("22-11-2000"));
        requestBillDTO.setName("name");

        ResponseBillDTO actual = billModelBuilder.createInstance(requestBillDTO);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(200D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDateDue(sdf.parse("22-11-2000"));
        expected.setName("name");

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);

    }

    @Test
    public void shouldReturnValidResponseBillWhenSendBillModelValid() throws ParseException {

        BillModel billModel = new BillModel();
        billModel.setPrice(200D);
        billModel.setPayday(sdf.parse("12-11-2000"));
        billModel.setDueDate(sdf.parse("22-11-2000"));
        billModel.setName("name");
        billModel.setPriceWithTax(100D);

        ResponseBillDTO actual = billModelBuilder.createInstance(billModel);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(200D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDateDue(sdf.parse("22-11-2000"));
        expected.setName("name");
        expected.setPriceWithTax(100D);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);

    }
}
