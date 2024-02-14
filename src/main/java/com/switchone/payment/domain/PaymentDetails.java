package com.switchone.payment.domain;


import com.switchone.payment.constants.ColumnSizeConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class PaymentDetails implements Serializable {

    private static final long serialVersionUID = -4313306939943237518L;

    @Column(name = "card_number", length = ColumnSizeConstants.NAME)
    private String cardNumber;

    @Column(name = "expiry_date", length = 5)
    private String expiryDate;

    @Column(name = "cvv", length = 3)
    private String cvv;

    public PaymentDetails(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
}
