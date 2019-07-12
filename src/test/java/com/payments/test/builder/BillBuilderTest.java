package com.payments.builder;

import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BillBuilderTest {

    @InjectMocks
    private BillBuilder billModelBuilder;

    private String DATE_FORMAT = "dd-MM-yyyy";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Test
    public void shouldReturnValidResponseBillWhenSendRequestBillValid() throws ParseException {

        RequestBillDTO requestBillDTO = RequestBillDTO.builder()
                .price(200D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dueDate(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .name("name")
                .build();

        ResponseBillDTO actual = billModelBuilder.createInstance(requestBillDTO);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(200D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .name("name")
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);

    }

    @Test
    public void shouldReturnValidResponseBillWhenSendBillModelValid() throws ParseException {

        BillModel billModel = new BillModel();
        billModel.setPrice(200D);
        billModel.setPayday(LocalDate.parse("12-11-2000", dateTimeFormatter));
        billModel.setDueDate(LocalDate.parse("22-11-2000", dateTimeFormatter));
        billModel.setName("name");
        billModel.setPriceWithTax(100D);

        ResponseBillDTO actual = billModelBuilder.createInstance(billModel);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(200D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .name("name")
                .priceWithTax(100D)
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);

    }
}
