package com.switchone.payment.controller;

import com.switchone.payment.base.AbstractControllerTest;
import com.switchone.payment.domain.PaymentDetails;
import com.switchone.payment.enums.Currency;
import com.switchone.payment.model.ApprovalVO;
import com.switchone.payment.model.EstimateVO;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentControllerTest extends AbstractControllerTest {

    @Test
    void balance() throws Exception {
        mockMvc.perform(this.get("/api/payments/balance/12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(12345))
                .andExpect(jsonPath("$.balance").value(100000))
                .andExpect(jsonPath("$.currency").value("USD"));
    }

    @Test
    void estimate() throws Exception {
        EstimateVO estimateVO = EstimateVO.builder()
                .amount(15000L)
                .currency(Currency.USD)
                .destination("merchantId123")
                .userId(12345L)
                .build();

        mockMvc.perform(this.post("/api/payments/estimate")
                .content(jsonUtils.convertJsonString(estimateVO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void approval() throws Exception {
        ApprovalVO approvalVO = ApprovalVO.builder()
                .userId(12345L)
                .amount(20000L)
                .currency(Currency.USD)
                .merchantId("merchantId123")
                .paymentMethod("creditCard")
                .paymentDetails(new PaymentDetails("1234-5678-9123-4567", "12/24", "cvv"))
                .build();


        mockMvc.perform(this.post("/api/payments/approval")
                .content(jsonUtils.convertJsonString(approvalVO)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}