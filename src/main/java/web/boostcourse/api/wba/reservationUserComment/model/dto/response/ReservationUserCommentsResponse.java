package web.boostcourse.api.wba.reservationUserComment.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ReservationUserCommentsResponse {

    private Long totalCount;

    private Integer commentCount;

    private List<ReservationUserCommentResponse> reservationUserComments;

}
