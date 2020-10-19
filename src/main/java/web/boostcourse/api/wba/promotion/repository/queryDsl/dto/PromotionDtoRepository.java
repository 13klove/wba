package web.boostcourse.api.wba.promotion.repository.queryDsl.dto;

import web.boostcourse.api.wba.promotion.model.dto.response.PromotionResponse;

import java.util.List;

public interface PromotionDtoRepository {

    List<PromotionResponse> getPromotions();

}
