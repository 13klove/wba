package web.boostcourse.api.wba.reservationInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.ReservationInfosRequest;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.service.ReservationInfoService;

@RestController
@RequestMapping("api")
public class ReservationInfoController {

    @Autowired
    private ReservationInfoService reservationInfoService;

    @PostMapping("/reservationInfos")
    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfos(ReservationInfosRequest.RservationInfos reservationInfos){
        return reservationInfoService.reservationInfos(reservationInfos);
    }


}
