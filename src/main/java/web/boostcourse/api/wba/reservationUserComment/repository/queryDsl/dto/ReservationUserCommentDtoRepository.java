package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto;

import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;

public interface ReservationUserCommentDtoRepository {

    ReservationUserCommentResponse getAvgScore(Long productId);

}
