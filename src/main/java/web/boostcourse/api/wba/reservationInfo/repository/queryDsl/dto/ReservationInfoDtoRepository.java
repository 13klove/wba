package web.boostcourse.api.wba.reservationInfo.repository.queryDsl.dto;

import web.boostcourse.api.wba.reservationInfo.model.dto.response.RiResponse;

import java.util.List;

public interface ReservationInfoDtoRepository {

    List<RiResponse> getReservationInfos(Long userId);

}
