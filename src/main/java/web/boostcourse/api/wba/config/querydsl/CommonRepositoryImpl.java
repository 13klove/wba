package web.boostcourse.api.wba.config.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class CommonRepositoryImpl {

    private JPAQueryFactory jpaQueryFactory;

    public CommonRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

}
