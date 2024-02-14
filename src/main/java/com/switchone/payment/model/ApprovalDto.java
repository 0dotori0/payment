package com.switchone.payment.model;


import com.switchone.payment.enums.Currency;
import com.switchone.payment.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApprovalDto implements Serializable {

    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime timestamp;

    @Builder
    public ApprovalDto(Long paymentId, Status status, Long amount, Currency currency, LocalDateTime timestamp) {
        this.paymentId = paymentId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
    }
}
