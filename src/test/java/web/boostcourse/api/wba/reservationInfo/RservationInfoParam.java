package web.boostcourse.api.wba.reservationInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RservationInfoParam {

    private Long productId;

    private Long productPriceId;

    private Long displayInfoId;

    private String reservationYearMonthDay;

    private Long userId;

    private List<ProductPriceRequest.ProductPriceParam> prices;

}
