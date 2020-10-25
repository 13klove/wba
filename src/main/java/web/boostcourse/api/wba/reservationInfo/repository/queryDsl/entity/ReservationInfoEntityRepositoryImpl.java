package web.boostcourse.api.wba.reservationInfo.repository.queryDsl.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.EntityManager;

public class ReservationInfoEntityRepositoryImpl implements ReservationInfoEntityRepository{

    private JPAQueryFactory jpaQueryFactory;

    public ReservationInfoEntityRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public ReservationInfo getReservationInfo(String email) {
        return null;
    }
}
