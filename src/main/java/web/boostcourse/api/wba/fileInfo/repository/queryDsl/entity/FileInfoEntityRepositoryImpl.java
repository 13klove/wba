package web.boostcourse.api.wba.fileInfo.repository.queryDsl.entity;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class FileInfoEntityRepositoryImpl extends CommonRepositoryImpl implements FileInfoEntityRepository {

    public FileInfoEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
