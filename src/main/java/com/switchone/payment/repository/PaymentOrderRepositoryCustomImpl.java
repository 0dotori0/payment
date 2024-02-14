package com.switchone.payment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.switchone.payment.domain.QUserPayment;
import com.switchone.payment.domain.QUserPaymentOrder;
import com.switchone.payment.domain.UserPaymentOrder;
import com.switchone.payment.model.EstimateDto;
import com.switchone.payment.model.EstimateVO;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class PaymentOrderRepositoryCustomImpl implements PaymentOrderRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public EstimateDto findByUserPaymentOrder(EstimateVO estimateVO) {
        JPAQuery<UserPaymentOrder> jpaQuery = new JPAQuery<>(entityManager);
        QUserPaymentOrder userPaymentOrder = QUserPaymentOrder.userPaymentOrder;
        QUserPayment userPayment = QUserPayment.userPayment;

        return jpaQuery
                .select(Projections.constructor(EstimateDto.class
                        , userPaymentOrder.orderAmount
                        , userPaymentOrder.userPayment.currency))
                .from(userPaymentOrder)
                .leftJoin(userPaymentOrder.userPayment, userPayment)
                .on(userPaymentOrder.id.eq(userPayment.userPaymentOrder.id))
                .where(userPaymentOrder.user.id.eq(estimateVO.getUserId())
                .and(userPaymentOrder.orderAmount.eq(estimateVO.getAmount())
                .and(userPaymentOrder.merchantId.eq(estimateVO.getDestination()))
                .and(userPayment.currency.eq(estimateVO.getCurrency()))))
                .fetchOne();
    }
}
