package web.boostcourse.api.wba.reservationInfo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RservationInfosParam {

    private Long productId;

    private Long productPriceId;

    private Long displayInfoId;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    //@DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate reservationYearMonthDay;

    private Long userId;

    private List<ProductPriceRequest.ProductPriceParam> prices;

}
