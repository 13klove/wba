package web.boostcourse.api.wba.promotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.promotion.model.entity.Promotion;
import web.boostcourse.api.wba.promotion.repository.queryDsl.dto.PromotionDtoRepository;
import web.boostcourse.api.wba.promotion.repository.queryDsl.entity.PromotionEntityRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long>, PromotionDtoRepository, PromotionEntityRepository {
}
