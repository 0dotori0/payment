package com.switchone.payment.repository;


import com.switchone.payment.model.BalanceDto;

public interface UserPointRepositoryCustom {

    BalanceDto findByUserId(Long userId);
}