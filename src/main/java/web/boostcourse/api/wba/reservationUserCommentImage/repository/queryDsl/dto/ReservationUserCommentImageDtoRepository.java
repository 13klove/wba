package web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response.ReservationUserCommentImageResponse;

import java.util.List;

public interface ReservationUserCommentImageDtoRepository {

    List<ReservationUserCommentImageResponse> getRservationUserCommentImages(List<Long> reservationUserComments);

}
