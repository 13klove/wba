package web.boostcourse.api.wba.reservationInfoPrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.reservationInfoPrice.model.entity.ReservationInfoPrice;
import web.boostcourse.api.wba.reservationInfoPrice.repository.queryDsl.dto.ReservationInfoPriceDtoRepository;
import web.boostcourse.api.wba.reservationInfoPrice.repository.queryDsl.entity.ReservationInfoPriceEntityRepository;

public interface ReservationInfoPriceRepository extends JpaRepository<ReservationInfoPrice, Long>, ReservationInfoPriceDtoRepository, ReservationInfoPriceEntityRepository {
}
