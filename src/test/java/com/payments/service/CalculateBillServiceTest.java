package com.payments.service;

import com.payments.dto.ResponseBillDTO;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateBillServiceTest {

    CalculateBillService calculateBillService;
    Date date = new Date();
    String DATE_FORMAT = "dd-MM-yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);


    @Before
    public void before(){
        calculateBillService = new CalculateBillService();
    }

    @Test
    public void shouldCollectTaxWhenSendMorThenFiveDaysLatestBill() throws ParseException {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setPrice(100D);
        responseBillDTO.setPayday(sdf.parse("12-11-2000"));
        responseBillDTO.setDateDue(sdf.parse("22-11-2000"));

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(100D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDateDue(sdf.parse("22-11-2000"));
        expected.setPriceWithTax(180.00);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldCollectTaxWhenSendThreeDaysLatestBill() throws ParseException {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setPrice(100D);
        responseBillDTO.setPayday(sdf.parse("12-11-2000"));
        responseBillDTO.setDateDue(sdf.parse("15-11-2000"));

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(100D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDateDue(sdf.parse("15-11-2000"));
        expected.setPriceWithTax(123.00);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }


    @Test
    public void shouldCollectTaxWhenSendFourDaysLatestBill() throws ParseException {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setPrice(100D);
        responseBillDTO.setPayday(sdf.parse("12-11-2000"));
        responseBillDTO.setDateDue(sdf.parse("16-11-2000"));

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(100D);
        expected.setPayday(sdf.parse("12-11-2000"));
        expected.setDateDue(sdf.parse("16-11-2000"));
        expected.setPriceWithTax(138.00);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
    @Test
    public void shouldDoNothingWhenSendANotLatedBill() throws ParseException {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        responseBillDTO.setPrice(100D);
        responseBillDTO.setPayday(sdf.parse("22-11-2000"));
        responseBillDTO.setDateDue(sdf.parse("22-11-2000"));

        ResponseBillDTO actual = calculateBillService.calculateWithTax(responseBillDTO);

        ResponseBillDTO expected = new ResponseBillDTO();
        expected.setPrice(100D);
        expected.setPayday(sdf.parse("22-11-2000"));
        expected.setDateDue(sdf.parse("22-11-2000"));
        expected.setPriceWithTax(100D);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
