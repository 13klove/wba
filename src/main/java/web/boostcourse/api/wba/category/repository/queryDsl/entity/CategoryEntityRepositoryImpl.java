package web.boostcourse.api.wba.category.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class CategoryEntityRepositoryImpl extends CommonRepositoryImpl implements CategoryEntityRepository{

    public CategoryEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

//    private JPAQueryFactory jpaQueryFactory;
//
//    public CategoryEntityRepositoryImpl(EntityManager entityManager) {
//        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
//    }

}
