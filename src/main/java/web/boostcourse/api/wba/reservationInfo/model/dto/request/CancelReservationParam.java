package web.boostcourse.api.wba.reservationInfo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CancelReservationParam {

    private Long displayInfoId;

}
