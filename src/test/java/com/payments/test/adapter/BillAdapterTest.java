package com.payments.adapter;

import com.payments.builder.BillBuilder;
import com.payments.dto.RequestBillDTO;
import com.payments.dto.ResponseBillDTO;
import com.payments.model.BillModel;
import com.payments.service.BillService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BillAdapterTest {

    @InjectMocks
    private BillAdapter billAdapter;

    @Mock
    private BillBuilder billBuilder;

    @Mock
    private BillService billService;

    @Test
    public void shouldCallTheServiceAndBuilder() {
        RequestBillDTO requestBillDTO = new RequestBillDTO();
        ResponseBillDTO responseBillDTO = ResponseBillDTO.builder().build();

        doReturn(responseBillDTO).when(billBuilder).createInstance(requestBillDTO);
        doReturn(responseBillDTO).when(billService).create(responseBillDTO);

        ResponseBillDTO expected = billAdapter.crateBill(requestBillDTO);

        Assert.assertEquals(expected, responseBillDTO);

        verify(billBuilder).createInstance(requestBillDTO);
        verify(billBuilder, never()).createInstance((BillModel) any());
    }


}
