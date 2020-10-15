package web.boostcourse.api.wba.userRole.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class UserRoleDtoRepositoryImpl extends CommonRepositoryImpl implements UserRoleDtoRepository {

    public UserRoleDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
