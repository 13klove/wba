package web.boostcourse.api.wba.promotion.service.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionsResponse;

@SpringBootTest
public class PromotionCoreServiceTest {

    @Autowired
    PromotionCoreService promotionCoreService;

    @Test
    @Transactional
    public void getPromotions(){
        PromotionsResponse promotions = promotionCoreService.getPromotions();
        System.out.println(promotions);
        Assertions.assertNotNull(promotions);
    }

}
