package web.boostcourse.api.wba.reservationInfo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RisResponse {

    private Integer size;

    private List<RiResponse> items;

}
