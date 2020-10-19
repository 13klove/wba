package web.boostcourse.api.wba.promotion.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionResponse;
import web.boostcourse.api.wba.promotion.repository.PromotionRepository;

import java.util.List;

@SpringBootTest
public class PromotionDtoRepositoryTest {

    @Autowired
    PromotionRepository promotionRepository;

    @Test
    @Transactional
    public void getPromotions(){
        List<PromotionResponse> promotions = promotionRepository.getPromotions();
        System.out.println(promotions);
        Assertions.assertNotNull(promotions);
    }
}
