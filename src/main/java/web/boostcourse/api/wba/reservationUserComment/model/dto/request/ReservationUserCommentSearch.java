package web.boostcourse.api.wba.reservationUserComment.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ReservationUserCommentSearch {

    private Long productId;

}
