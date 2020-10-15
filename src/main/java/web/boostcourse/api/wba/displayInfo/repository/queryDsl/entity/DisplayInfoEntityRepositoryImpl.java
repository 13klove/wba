package web.boostcourse.api.wba.displayInfo.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class DisplayInfoEntityRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoEntityRepository {

    public DisplayInfoEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
