package web.boostcourse.api.wba.promotion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionsResponse;
import web.boostcourse.api.wba.promotion.service.core.PromotionCoreService;

@Service
@Transactional(readOnly = true)
public class PromotionService {

    @Autowired
    private PromotionCoreService promotionCoreService;

    public PromotionsResponse getPromotions(){
        return promotionCoreService.getPromotions();
    }

}
