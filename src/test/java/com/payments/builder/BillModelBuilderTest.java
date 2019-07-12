package com.payments.builder;

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
public class BillModelBuilderTest {

    @InjectMocks
    private BillModelBuilder billModelBuilder;

    private String DATE_FORMAT = "dd-MM-yyyy";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Test
    public void shouldReturnValidBillModel() throws ParseException {

        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder()
                .price(200D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .name("name")
                .priceWithTax(100D)
                .build();

        BillModel actual = billModelBuilder.createInstance(responseBillDTO);

        BillModel expected = new BillModel();
        expected.setPrice(200D);
        expected.setPayday(LocalDate.parse("12-11-2000", dateTimeFormatter));
        expected.setDueDate(LocalDate.parse("22-11-2000", dateTimeFormatter));
        expected.setName("name");
        expected.setPriceWithTax(100D);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
