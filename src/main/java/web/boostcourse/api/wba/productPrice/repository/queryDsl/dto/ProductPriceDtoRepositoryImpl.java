package web.boostcourse.api.wba.productPrice.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductPriceDtoRepositoryImpl extends CommonRepositoryImpl implements ProductPriceDtoRepository {

    public ProductPriceDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
