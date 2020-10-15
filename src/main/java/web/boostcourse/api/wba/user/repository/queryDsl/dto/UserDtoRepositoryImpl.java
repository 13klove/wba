package web.boostcourse.api.wba.user.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class UserDtoRepositoryImpl extends CommonRepositoryImpl implements UserDtoRepository {

    public UserDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
