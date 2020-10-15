package web.boostcourse.api.wba.reservationInfoPrice.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationInfoPriceDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationInfoPriceDtoRepository {

    public ReservationInfoPriceDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
