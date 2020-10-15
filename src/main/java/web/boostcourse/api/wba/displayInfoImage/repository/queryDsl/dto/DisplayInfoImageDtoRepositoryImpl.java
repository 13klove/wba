package web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class DisplayInfoImageDtoRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoImageDtoRepository {

    public DisplayInfoImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
