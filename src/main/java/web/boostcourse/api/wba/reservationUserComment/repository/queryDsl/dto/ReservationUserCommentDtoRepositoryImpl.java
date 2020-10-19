package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.QReservationUserCommentResponse;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;

import javax.persistence.EntityManager;

import static web.boostcourse.api.wba.reservationUserComment.model.entity.QReservationUserComment.reservationUserComment;
import static web.boostcourse.api.wba.user.model.entity.QUser.user;

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

    @Override
    public Page<ReservationUserCommentResponse> getComments(Long productId, Pageable pageable) {
        QueryResults<ReservationUserCommentResponse> reservationUserCommentResponseQueryResults = getJpaQueryFactory().select(new QReservationUserCommentResponse(reservationUserComment.id, reservationUserComment.product.id
                , reservationUserComment.reservationInfo.id, reservationUserComment.score, reservationUserComment.user.email, reservationUserComment.comment
                , reservationUserComment.createDate, reservationUserComment.modifyDate))
                .from(reservationUserComment)
                .join(reservationUserComment.user, user)
                .where(whereProductId(productId))
                .limit(pageable.getPageSize())
                .offset(pageable.getPageNumber())
                .fetchResults();

        return new PageImpl<>(reservationUserCommentResponseQueryResults.getResults(), pageable, reservationUserCommentResponseQueryResults.getTotal());
    }

    private BooleanExpression whereProductId(Long productId) {
        return productId==null?null:reservationUserComment.product.id.eq(productId);
    }
}
