package web.boostcourse.api.wba.category.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class CategoryDtoRepositoryImpl extends CommonRepositoryImpl implements CategoryDtoRepository{

    public CategoryDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

//    private JPAQueryFactory jpaQueryFactory;
//
//    public CategoryDtoRepositoryImpl(EntityManager entityManager) {
//        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
//    }

}
