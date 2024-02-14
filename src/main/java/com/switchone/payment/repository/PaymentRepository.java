package com.switchone.payment.repository;


import com.switchone.payment.domain.UserPayment;

public interface PaymentRepository extends GenericRepository<UserPayment, Long>, PaymentRepositoryCustom {
}
