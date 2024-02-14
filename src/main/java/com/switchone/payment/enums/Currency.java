package com.switchone.payment.enums;

import lombok.Getter;

@Getter
public enum Currency {
    USD("USD", 5, "USD"),
    KRW("KRW",  500,"KRW");

    private final String type;
    private final int fee;
    private final String value;

    Currency(String type, int fee, String value) {
        this.type = type;
        this.fee = fee;
        this.value = value;
    }
}
