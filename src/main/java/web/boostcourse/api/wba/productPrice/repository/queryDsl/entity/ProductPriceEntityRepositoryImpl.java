package web.boostcourse.api.wba.productPrice.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductPriceEntityRepositoryImpl extends CommonRepositoryImpl implements ProductPriceEntityRepository {

    public ProductPriceEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
