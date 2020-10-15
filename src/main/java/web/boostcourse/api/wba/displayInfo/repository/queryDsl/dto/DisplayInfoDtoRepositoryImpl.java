package web.boostcourse.api.wba.displayInfo.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class DisplayInfoDtoRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoDtoRepository {

    public DisplayInfoDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
