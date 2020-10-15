package web.boostcourse.api.wba.displayInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.displayInfo.repository.queryDsl.dto.DisplayInfoDtoRepository;
import web.boostcourse.api.wba.displayInfo.repository.queryDsl.entity.DisplayInfoEntityRepository;

public interface DisplayInfoRepository extends JpaRepository<DisplayInfo, Long>, DisplayInfoDtoRepository, DisplayInfoEntityRepository {
}
