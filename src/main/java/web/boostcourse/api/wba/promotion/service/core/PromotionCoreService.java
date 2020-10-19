package web.boostcourse.api.wba.promotion.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionResponse;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionsResponse;
import web.boostcourse.api.wba.promotion.repository.PromotionRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PromotionCoreService {

    @Autowired
    private PromotionRepository promotionRepository;

    public PromotionsResponse getPromotions(){
        List<PromotionResponse> promotions = promotionRepository.getPromotions();
        return PromotionsResponse.builder().size(promotions.size()).items(promotions).build();
    }

}
