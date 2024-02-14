package com.switchone.payment.service;

import com.switchone.payment.domain.User;
import com.switchone.payment.domain.UserPayment;
import com.switchone.payment.domain.UserPaymentOrder;
import com.switchone.payment.model.ApprovalDto;
import com.switchone.payment.model.ApprovalVO;
import com.switchone.payment.model.EstimateDto;
import com.switchone.payment.model.EstimateVO;
import com.switchone.payment.repository.PaymentOrderRepository;
import com.switchone.payment.repository.PaymentRepository;
import com.switchone.payment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final UserRepository userRepository;

    private final PaymentOrderRepository paymentOrderRepository;

    private final PaymentRepository paymentRepository;


    @Transactional
    public ApprovalDto approval(ApprovalVO approvalVO) {
        User user = userRepository.findById(approvalVO.getUserId()).orElse(null);

        if (Objects.isNull(user)) {
            throw new NullPointerException();
        }

        UserPayment userPayment = new UserPayment();
        userPayment.approval(approvalVO);

        UserPaymentOrder userPaymentOrder = new UserPaymentOrder(user, approvalVO.getMerchantId(), approvalVO.getAmount(), userPayment);
        userPaymentOrder = paymentOrderRepository.save(userPaymentOrder);

        return ApprovalDto.builder()
                .paymentId(userPaymentOrder.getUserPayment().getId())
                .amount(userPaymentOrder.getOrderAmount())
                .currency(userPaymentOrder.getUserPayment().getCurrency())
                .status(userPaymentOrder.getUserPayment().getStatus())
                .timestamp(userPaymentOrder.getUserPayment().getCreatedDt())
                .build();

    }

    public EstimateDto estimate(EstimateVO estimateVO) {
        EstimateDto estimateDto = paymentOrderRepository.findByUserPaymentOrder(estimateVO);

        if (Objects.isNull(estimateDto)) {
            throw new NullPointerException();
        }

        return estimateDto;
    }
}
