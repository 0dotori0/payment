package com.switchone.payment.repository;

import com.switchone.payment.model.EstimateDto;
import com.switchone.payment.model.EstimateVO;

public interface PaymentOrderRepositoryCustom {

    EstimateDto findByUserPaymentOrder(EstimateVO estimateVO);
//    ServerInfoDto getServerInfo(String timeZoneCd, Long id, Integer authType);
//
//    ServerEmailInfoVO findByServerEmailInfo(Long serverId);
}
