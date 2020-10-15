package web.boostcourse.api.wba.productImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class ProductImageDtoRepositoryImpl extends CommonRepositoryImpl implements ProductImageDtoRepository {

    public ProductImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
