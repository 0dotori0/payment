package com.switchone.payment.domain;


import com.switchone.payment.constants.ColumnSizeConstants;
import com.switchone.payment.enums.Currency;
import com.switchone.payment.enums.Status;
import com.switchone.payment.model.ApprovalVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_payment")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString
public class UserPayment extends AbstractTimestampEntity<Long> {

    private static final long serialVersionUID = -4313306939943237518L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

//    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "payment_order_id")
    @OneToOne(mappedBy = "userPayment", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private UserPaymentOrder userPaymentOrder;

    @Column(name = "payment_account")
    private Long amount;

    @Column(name = "payment_method", length = ColumnSizeConstants.VALUE)
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private PaymentDetails paymentDetails;

    public void approval(ApprovalVO approvalVO){
        this.amount = approvalVO.getAmount() + approvalVO.getCurrency().getFee();
        this.currency = approvalVO.getCurrency();
        this.paymentMethod = approvalVO.getPaymentMethod();
        this.status = Status.APPROVED;
        this.paymentDetails = approvalVO.getPaymentDetails();
    }

}
