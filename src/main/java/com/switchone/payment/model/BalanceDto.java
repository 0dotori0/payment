package com.switchone.payment.model;


import com.switchone.payment.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class BalanceDto implements Serializable {

    private Long userId;

    private Long balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Builder
    public BalanceDto(Long userId, Long balance, Currency currency) {
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }
}
