package web.boostcourse.api.wba.reservationInfoPrice.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationInfoPriceEntityRepositoryImpl extends CommonRepositoryImpl implements ReservationInfoPriceEntityRepository {

    public ReservationInfoPriceEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
