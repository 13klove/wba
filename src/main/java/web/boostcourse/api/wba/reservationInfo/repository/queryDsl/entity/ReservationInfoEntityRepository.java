package web.boostcourse.api.wba.reservationInfo.repository.queryDsl.entity;

import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

public interface ReservationInfoEntityRepository {

    ReservationInfo getReservationInfo(String email);

}
