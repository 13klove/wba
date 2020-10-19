package web.boostcourse.api.wba.productImage.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.productImage.model.ImageType;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductImageResponse {

    private Long productId;

    private Long productImageId;

    private ImageType type;

    private Long fileInfoId;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private Boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @QueryProjection
    public ProductImageResponse(Long productId, Long productImageId, ImageType type, Long fileInfoId, String fileName, String saveFileName, String contentType, Boolean deleteFlag, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.productId = productId;
        this.productImageId = productImageId;
        this.type = type;
        this.fileInfoId = fileInfoId;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.deleteFlag = deleteFlag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
