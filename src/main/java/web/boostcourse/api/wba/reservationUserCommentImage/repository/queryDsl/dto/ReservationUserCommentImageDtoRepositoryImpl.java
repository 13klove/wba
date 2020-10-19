package web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response.QReservationUserCommentImageResponse;
import web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response.ReservationUserCommentImageResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.fileInfo.model.entity.QFileInfo.fileInfo;
import static web.boostcourse.api.wba.reservationUserCommentImage.model.entity.QReservationUserCommentImage.reservationUserCommentImage;

public class ReservationUserCommentImageDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationUserCommentImageDtoRepository {

    public ReservationUserCommentImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ReservationUserCommentImageResponse> getRservationUserCommentImages(List<Long> reservationUserComments) {
        return getJpaQueryFactory().select(new QReservationUserCommentImageResponse(reservationUserCommentImage.id, reservationUserCommentImage.reservationInfo.id
        , reservationUserCommentImage.reservationUserComment.id, fileInfo.id, fileInfo.fileName, fileInfo.saveFileName, fileInfo.contentType, fileInfo.deleteFlag, fileInfo.createDate, fileInfo.modifyDate))
                .from(reservationUserCommentImage)
                .join(reservationUserCommentImage.fileInfo, fileInfo)
                .where(whereReservationUserCommentIds(reservationUserComments))
                .fetch();
    }

    private BooleanExpression whereReservationUserCommentIds(List<Long> reservationUserComments) {
        return reservationUserComments==null||reservationUserComments.isEmpty()?null:reservationUserCommentImage.reservationUserComment.id.in(reservationUserComments);
    }

}
