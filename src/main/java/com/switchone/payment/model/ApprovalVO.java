package com.switchone.payment.model;


import com.switchone.payment.domain.PaymentDetails;
import com.switchone.payment.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ApprovalVO implements Serializable {

    private Long userId;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String merchantId;

    private String paymentMethod;

    private PaymentDetails paymentDetails;

    @Builder
    public ApprovalVO(Long userId, Long amount, Currency currency, String merchantId, String paymentMethod, PaymentDetails paymentDetails) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.merchantId = merchantId;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }
}
