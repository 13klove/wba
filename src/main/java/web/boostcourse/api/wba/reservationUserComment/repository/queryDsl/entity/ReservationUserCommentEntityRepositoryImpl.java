package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationUserCommentEntityRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentEntityRepository {

    public ReservationUserCommentEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
