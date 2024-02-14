package com.switchone.payment.service;

import com.switchone.payment.domain.UserPoint;
import com.switchone.payment.model.BalanceDto;
import com.switchone.payment.repository.UserPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserPointService {

    private final UserPointRepository userPointRepository;

    public BalanceDto balance(Long userId) {
        BalanceDto balanceDto = userPointRepository.findByUserId(userId);

        if (Objects.isNull(balanceDto)) {
            throw new NullPointerException();
        }

        return balanceDto;
    }
}
