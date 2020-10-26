package web.boostcourse.api.wba.reservationInfo.service;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.CancelReservationParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.RservationInfosParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RisResponse;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationInfo.service.convert.ReservationInfoConvertService;
import web.boostcourse.api.wba.reservationInfo.service.core.ReservationInfoCoreService;
import web.boostcourse.api.wba.reservationInfo.service.valid.ReservationInfoValidService;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.user.repository.UserRepository;

import java.util.Map;


@Service
@Transactional(readOnly = true)
public class ReservationInfoService {

    @Autowired
    private ReservationInfoValidService reservationInfoValidService;
    @Autowired
    private ReservationInfoCoreService reservationInfoCoreService;
    @Autowired
    private ReservationInfoConvertService reservationInfoConvertService;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfos(RservationInfosParam reservationInfos){
        //벨리데이션
        reservationInfoValidService.reservationInfos(reservationInfos);

        //등록
        ReservationInfo reservationInfo = reservationInfoCoreService.reservationInfos(reservationInfos);

        //ENTITY -> DTO 컨버트
        return reservationInfoConvertService.reservationInfoConv(reservationInfo);
    }

    public RisResponse getReservationInfos(){
        //user 조회
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //web.boostcourse.api.wba.user.model.entity.User dbUser = userRepository.findUserByEmail(user.getUsername()).get();

        //데이터 조회
        return reservationInfoCoreService.getReservationInfos(user.getId());
    }

    @Transactional
    public Map<String, String> cancelReservation(CancelReservationParam param){
        //벨리데이션
        reservationInfoValidService.cancelReservation(param);

        //취소
        reservationInfoCoreService.cancelReservation(param);

        //결과
        //todo 여기가 마음에 안든다. 결과 반환 방식을 변경하고 싶지만 일단 그냥 둔다.
        Map<String, String> result = Maps.newHashMap();
        result.put("result", "success");
        return result;
    }

}
