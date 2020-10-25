package web.boostcourse.api.wba.productPrice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ProductPriceRequest {

    @Data
    @Builder
    @AllArgsConstructor
    public static class ProductPriceParam{

        private Integer count;

        private Long productPriceId;

    }

}
