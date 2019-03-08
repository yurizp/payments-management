package com.payments.api;

import com.payments.adapter.BillAdapter;
import com.payments.dto.ResponseBillDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BillApi.class)
@ActiveProfiles("test")
public class BillApiTest {

    @MockBean
    private BillAdapter billAdapter;

    @Autowired
    private MockMvc mockMvc;

    private final String URL = "/v1/bill";

    @Test
    public void shouldReturnSucess() throws Exception {

        ResponseBillDTO responseBillDTO = new ResponseBillDTO();
        doReturn(responseBillDTO).when(billAdapter).crateBill(any());

        mockMvc.perform(post(URL)
                .content(new String(Files.readAllBytes(Paths.get("json/bill.json"))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
