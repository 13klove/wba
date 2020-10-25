package web.boostcourse.api.wba.reservationInfo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;

import java.time.LocalDate;
import java.util.List;

public class ReservationInfosRequest {

    @Data
    @Builder
    @AllArgsConstructor
    public static class RservationInfos{

        private Long productId;

        private Long productPriceId;

        private Long displayInfoId;

        private LocalDate reservationYearMonthDay;

        private Long userId;

        private List<ProductPriceRequest.ProductPriceParam> prices;

    }



}
