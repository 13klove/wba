package web.boostcourse.api.wba.productPrice.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.productPrice.model.ProductTypeName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductPriceResponse {

    private Long id;

    private Long productId;

    private ProductTypeName priceTypeName;

    private Integer price;

    private BigDecimal discountRate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @QueryProjection
    public ProductPriceResponse(Long id, Long productId, ProductTypeName priceTypeName, Integer price, BigDecimal discountRate, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.priceTypeName = priceTypeName;
        this.price = price;
        this.discountRate = discountRate;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
