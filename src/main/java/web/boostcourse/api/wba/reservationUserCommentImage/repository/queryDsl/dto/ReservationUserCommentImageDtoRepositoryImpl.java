package web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ReservationUserCommentImageDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentImageDtoRepository {

    public ReservationUserCommentImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
