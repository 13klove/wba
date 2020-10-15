package web.boostcourse.api.wba.product.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductEntityRepositoryImpl extends CommonRepositoryImpl implements ProductEntityRepository {

    public ProductEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
