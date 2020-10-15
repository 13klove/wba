package web.boostcourse.api.wba.productImage.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductImageEntityRepositoryImpl extends CommonRepositoryImpl implements ProductImageEntityRepository {

    public ProductImageEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
