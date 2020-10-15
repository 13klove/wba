package web.boostcourse.api.wba.product.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductDtoRepositoryImpl extends CommonRepositoryImpl implements ProductDtoRepository {

    public ProductDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
