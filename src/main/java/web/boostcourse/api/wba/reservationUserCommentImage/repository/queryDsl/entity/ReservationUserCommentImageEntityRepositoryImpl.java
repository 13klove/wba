package web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationUserCommentImageEntityRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentImageEntityRepository {

    public ReservationUserCommentImageEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
