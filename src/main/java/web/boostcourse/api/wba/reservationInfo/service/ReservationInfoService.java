package web.boostcourse.api.wba.reservationInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.ReservationInfosRequest;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.service.core.ReservationInfoCoreService;

@Service
@Transactional(readOnly = true)
public class ReservationInfoService {

    @Autowired
    private ReservationInfoCoreService reservationInfoCoreService;

    @Transactional
    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfos(ReservationInfosRequest.RservationInfos reservationInfos){
         return reservationInfoCoreService.reservationInfos(reservationInfos);
    }

}
