package web.boostcourse.api.wba.reservationUserComment.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response.ReservationUserCommentImageResponse;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ReservationUserCommentResponse {

    private Double avgScore;

    private Long id;

    private Long productId;

    private Long reservationInfoId;

    private Long score;

    private String reservationEmail;

    private String comment;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private List<ReservationUserCommentImageResponse> reservationUserCommentImages;

    @QueryProjection
    public ReservationUserCommentResponse(Double avgScore) {
        this.avgScore = avgScore;
    }

    @QueryProjection
    public ReservationUserCommentResponse(Long id, Long productId, Long reservationInfoId, Long score, String reservationEmail, String comment, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.reservationEmail = reservationEmail;
        this.comment = comment;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
