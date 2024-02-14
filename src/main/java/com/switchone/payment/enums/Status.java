package com.switchone.payment.enums;

import lombok.Getter;

@Getter
public enum Status {
    APPLY("apply", 10, "요청"),
    APPROVED("approved", 20, "승인"),
    CANCEL("cancel", 90, "취소");

    private final String value;
    private final int code;
    private final String description;

    Status(String value, int code, String description) {
        this.value = value;
        this.code = code;
        this.description = description;
    }
}
