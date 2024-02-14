package com.switchone.payment.service;

import com.switchone.payment.base.AbstractServiceTest;
import com.switchone.payment.repository.PaymentOrderRepository;
import com.switchone.payment.repository.PaymentRepository;
import com.switchone.payment.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class PaymentServiceTest extends AbstractServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentOrderRepository paymentOrderRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    private void setup() {
        this.paymentService = new PaymentService(userRepository, paymentOrderRepository, paymentRepository);
    }

    @Test
    void approval() {
    }

    @Test
    void estimate() {


    }
}