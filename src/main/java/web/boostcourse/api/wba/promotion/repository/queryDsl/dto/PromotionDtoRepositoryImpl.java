package web.boostcourse.api.wba.promotion.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class PromotionDtoRepositoryImpl extends CommonRepositoryImpl implements PromotionDtoRepository {

    public PromotionDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
