package web.boostcourse.api.wba.reservationInfoPrice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ReservationInfoPriceResponse {

    @Data
    @Builder
    @AllArgsConstructor
    public static class ReservationInfoPriceRes{

        private Long id;

        private Long reservationInfoId;

        private Long productPriceId;

        private Integer count;

    }

}
