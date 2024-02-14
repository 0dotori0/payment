package com.switchone.payment.repository;


import com.switchone.payment.domain.UserPaymentOrder;

public interface PaymentOrderRepository extends GenericRepository<UserPaymentOrder, Long>, PaymentOrderRepositoryCustom {

}
