package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationUserCommentDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentDtoRepository {

    public ReservationUserCommentDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
