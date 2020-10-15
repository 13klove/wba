package web.boostcourse.api.wba.promotion.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class PromotionEntityRepositoryImpl extends CommonRepositoryImpl implements PromotionEntityRepository {

    public PromotionEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
