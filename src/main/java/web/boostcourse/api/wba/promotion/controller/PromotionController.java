package web.boostcourse.api.wba.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionsResponse;
import web.boostcourse.api.wba.promotion.service.PromotionService;

@RestController
@RequestMapping("api")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotions")
    public PromotionsResponse getPromotions(){
        return promotionService.getPromotions();
    }

}
