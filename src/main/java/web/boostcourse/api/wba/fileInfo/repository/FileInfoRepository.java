package web.boostcourse.api.wba.fileInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.fileInfo.model.entity.FileInfo;
import web.boostcourse.api.wba.fileInfo.repository.queryDsl.dto.FileInfoDtoRepository;
import web.boostcourse.api.wba.fileInfo.repository.queryDsl.entity.FileInfoEntityRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long>, FileInfoDtoRepository, FileInfoEntityRepository {
}
