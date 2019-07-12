package com.payments.service;

import com.payments.dto.ResponseBillDTO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateBillServiceTest {

    private CalculateBillService calculateBillService;
    private String DATE_FORMAT = "dd-MM-yyyy";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);


    @Before
    public void before() {
        calculateBillService = new CalculateBillService();
    }

    @Test
    public void shouldCollectTaxWhenSendMorThenFiveDaysLatestBill() {

        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .build();

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .priceWithTax(180.00)
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldCollectTaxWhenSendThreeDaysLatestBill(){

        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("15-11-2000", dateTimeFormatter))
                .build();

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("15-11-2000", dateTimeFormatter))
                .priceWithTax(123.00)
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }


    @Test
    public void shouldCollectTaxWhenSendFourDaysLatestBill() {

        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("16-11-2000", dateTimeFormatter))
                .build();

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("12-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("16-11-2000", dateTimeFormatter))
                .priceWithTax(138.00)
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldDoNothingWhenSendANotLatedBill() {

        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .build();

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = ResponseBillDTO.builder()
                .price(100D)
                .payday(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .dateDue(LocalDate.parse("22-11-2000", dateTimeFormatter))
                .priceWithTax(100D)
                .build();

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
