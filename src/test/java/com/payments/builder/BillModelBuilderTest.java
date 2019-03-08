package com.payments.builder;

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
public class BillModelBuilderTest {

    @InjectMocks
    private BillModelBuilder billModelBuilder;

    private String DATE_FORMAT = "dd-MM-yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    @Test
    public void shouldReturnValidBillModel() throws ParseException {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setPrice(200D);
        responseBillDTO.setPayday(sdf.parse("12-11-2000"));
        responseBillDTO.setDateDue(sdf.parse("22-11-2000"));
        responseBillDTO.setName("name");
        responseBillDTO.setPriceWithTax(100D);

        BillModel actual = billModelBuilder.createInstance(responseBillDTO);

        BillModel expected = new BillModel();
        expected.setPrice(200D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDueDate(sdf.parse("22-11-2000"));
        expected.setName("name");
        expected.setPriceWithTax(100D);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
