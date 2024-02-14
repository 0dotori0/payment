package com.switchone.payment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.switchone.payment.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Getter
@Setter
public class EstimateDto implements Serializable {

    @JsonIgnore
    private Long amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;


    @Builder
    public EstimateDto(Long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Long getEstimatedTotal() {
        return this.amount + currency.getFee();

    }

    public Integer getFee() {
        return currency.getFee();
    }


}
