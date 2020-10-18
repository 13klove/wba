package web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationUserCommentImageResponse {

    private Long id;

    private Long reservationInfoId;

    private Long reservationUserCommentId;

    private Long fileId;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private Boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @QueryProjection
    public ReservationUserCommentImageResponse(Long id, Long reservationInfoId, Long reservationUserCommentId, Long fileId, String fileName, String saveFileName, String contentType, Boolean deleteFlag, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.reservationInfoId = reservationInfoId;
        this.reservationUserCommentId = reservationUserCommentId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.deleteFlag = deleteFlag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

}
