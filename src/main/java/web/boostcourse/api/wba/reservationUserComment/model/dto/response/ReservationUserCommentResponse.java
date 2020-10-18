package web.boostcourse.api.wba.reservationUserComment.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationUserCommentResponse {

    private Double avgScore;

    @QueryProjection
    public ReservationUserCommentResponse(Double avgScore) {
        this.avgScore = avgScore;
    }
}
