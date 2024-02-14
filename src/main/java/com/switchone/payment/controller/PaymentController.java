package com.switchone.payment.controller;

import com.switchone.payment.model.*;
import com.switchone.payment.service.PaymentService;
import com.switchone.payment.service.UserPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    private final UserPointService userPointService;

    @GetMapping("/balance/{userId}")
    public BalanceDto balance(@PathVariable Long userId) {
        return userPointService.balance(userId);
    }


    @PostMapping("/estimate")
    public EstimateDto estimate(@RequestBody EstimateVO estimateVO) {
        return paymentService.estimate(estimateVO);
    }

    @PostMapping("/approval")
    public ApprovalDto approval(@RequestBody ApprovalVO approvalVO) {
        return paymentService.approval(approvalVO);
    }
}
