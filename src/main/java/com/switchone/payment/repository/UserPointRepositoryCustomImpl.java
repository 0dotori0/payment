package com.switchone.payment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.switchone.payment.domain.QUserPoint;
import com.switchone.payment.domain.UserPoint;
import com.switchone.payment.enums.Currency;
import com.switchone.payment.model.BalanceDto;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class UserPointRepositoryCustomImpl implements UserPointRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public BalanceDto findByUserId(Long userId) {
        JPAQuery<UserPoint> jpaQuery = new JPAQuery<>(entityManager);
        QUserPoint userPoint = QUserPoint.userPoint;

        return jpaQuery
                .select(Projections.constructor(BalanceDto.class
                        , userPoint.user.id.as("userId")
                        , userPoint.balance
                        , userPoint.currency))
                .from(userPoint)
                .where(userPoint.user.id.eq(userId))
                .fetchOne();
    }
}
