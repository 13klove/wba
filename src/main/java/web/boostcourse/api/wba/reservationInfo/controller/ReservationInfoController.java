package web.boostcourse.api.wba.reservationInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.CancelReservationParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.RservationInfosParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RisResponse;
import web.boostcourse.api.wba.reservationInfo.service.ReservationInfoService;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ReservationInfoController {

    @Autowired
    private ReservationInfoService reservationInfoService;

    @PostMapping("/reservationInfos")
    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfos(@RequestBody RservationInfosParam reservationInfos){
        return reservationInfoService.reservationInfos(reservationInfos);
    }

    @GetMapping("/reservationInfos")
    public RisResponse getReservationInfos(){
        return reservationInfoService.getReservationInfos();
    }

    @PutMapping("/reservationInfos")
    public Map<String, String> cancelReservation(@RequestBody CancelReservationParam cancelReservationParam){
        System.out.println("@@@@@@@@@@@@@!!!!!!!!!!!!!!!!"+cancelReservationParam);
        return reservationInfoService.cancelReservation(cancelReservationParam);
    }

}
