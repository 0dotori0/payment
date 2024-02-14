package com.switchone.payment.domain;


import com.switchone.payment.constants.ColumnSizeConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_payment_order")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString
public class UserPaymentOrder extends AbstractTimestampEntity<Long> {

    private static final long serialVersionUID = -4313306939943237518L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Column(name = "merchant_id", length = ColumnSizeConstants.NAME)
    private String merchantId;

    @Column(name = "payment_order_amount")
    private Long orderAmount;

//    @OneToOne(mappedBy = "userPaymentOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payment_id")
    private UserPayment userPayment;

    public UserPaymentOrder(User user, String merchantId, Long orderAmount, UserPayment userPayment) {
        this.user = user;
        this.merchantId = merchantId;
        this.orderAmount = orderAmount;
        this.userPayment = userPayment;
    }
}
