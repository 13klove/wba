package web.boostcourse.api.wba.reservationInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationInfo.repository.queryDsl.dto.ReservationInfoDtoRepository;
import web.boostcourse.api.wba.reservationInfo.repository.queryDsl.entity.ReservationInfoEntityRepository;

public interface ReservationInfoRepository extends JpaRepository<ReservationInfo, Long>, ReservationInfoEntityRepository, ReservationInfoDtoRepository {
}
