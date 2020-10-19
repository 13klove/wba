package web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;

public interface ReservationUserCommentDtoRepository {

    ReservationUserCommentResponse getAvgScore(Long productId);

    Page<ReservationUserCommentResponse> getComments(Long productId, Pageable pageable);

}
