package web.boostcourse.api.wba.displayInfoImage.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DisplayInfoImageResponse {

    private Long id;

    private Long displayInfoId;

    private Long fileId;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private Boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @QueryProjection
    public DisplayInfoImageResponse(Long id, Long displayInfoId, Long fileId, String fileName, String saveFileName, String contentType, Boolean deleteFlag, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.displayInfoId = displayInfoId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.deleteFlag = deleteFlag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
