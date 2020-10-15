package web.boostcourse.api.wba.user.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class UserEntityRepositoryImpl extends CommonRepositoryImpl implements UserEntityRepository {

    public UserEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
