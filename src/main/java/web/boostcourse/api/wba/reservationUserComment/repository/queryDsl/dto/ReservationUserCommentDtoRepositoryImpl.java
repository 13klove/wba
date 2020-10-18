package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.QReservationUserCommentResponse;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;

import javax.persistence.EntityManager;

import static web.boostcourse.api.wba.reservationUserComment.model.entity.QReservationUserComment.reservationUserComment;

public class ReservationUserCommentDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentDtoRepository {

    public ReservationUserCommentDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ReservationUserCommentResponse getAvgScore(Long productId) {
        return getJpaQueryFactory().select(new QReservationUserCommentResponse(reservationUserComment.score.avg()))
                .from(reservationUserComment)
                .where(whereProductId(productId))
                .fetchOne();
    }

    private BooleanExpression whereProductId(Long productId) {
        return productId==null?null:reservationUserComment.product.id.eq(productId);
    }
}
