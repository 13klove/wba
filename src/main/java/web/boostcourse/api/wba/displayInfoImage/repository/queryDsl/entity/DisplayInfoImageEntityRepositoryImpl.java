package web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class DisplayInfoImageEntityRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoImageEntityRepository {

    public DisplayInfoImageEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
