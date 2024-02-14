package com.switchone.payment.model;


import com.switchone.payment.enums.Currency;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EstimateVO implements Serializable {

    private Long userId;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String destination;

    @Builder
    public EstimateVO(Long userId, Long amount, Currency currency, String destination) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.destination = destination;
    }
}
