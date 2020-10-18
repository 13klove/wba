package web.boostcourse.api.wba.promotion.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PromotionsResponse {

    private Integer size;

    private List<PromotionResponse> items;

}
