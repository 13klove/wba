package web.boostcourse.api.wba.reservationInfo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.reservationInfoPrice.model.dto.response.ReservationInfoPriceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationInfoDtoResponse {

    @Data
    @Builder
    @AllArgsConstructor
    public static class ReservationInfoResponse{

        private Long id;

        private Long productId;

        private Boolean cancelFlag;

        private Long displayInfoId;

        private Long userId;

        private LocalDate reservationDate;

        private LocalDateTime createDate;

        private LocalDateTime modifyDate;

        private List<ReservationInfoPriceResponse.ReservationInfoPriceRes> prices;

    }

}
