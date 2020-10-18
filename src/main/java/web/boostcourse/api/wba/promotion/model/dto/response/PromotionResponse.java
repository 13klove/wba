package web.boostcourse.api.wba.promotion.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionResponse {

    private Long id;

    private Long productId;

    private Long CategoryId;

    private String categoryName;

    private String description;

    private Long fileId;

    @QueryProjection
    public PromotionResponse(Long id, Long productId, Long categoryId, String categoryName, String description, Long fileId) {
        this.id = id;
        this.productId = productId;
        this.CategoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.fileId = fileId;
    }
}
