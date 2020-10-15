package web.boostcourse.api.wba.userRole.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class UserRoleEntityRepositoryImpl extends CommonRepositoryImpl implements UserRoleEntityRepository {

    public UserRoleEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
