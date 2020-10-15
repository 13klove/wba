package web.boostcourse.api.wba.fileInfo.repository.queryDsl.dto;

import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;

import javax.persistence.EntityManager;

public class FileInfoDtoRepositoryImpl extends CommonRepositoryImpl implements FileInfoDtoRepository {

    public FileInfoDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}
