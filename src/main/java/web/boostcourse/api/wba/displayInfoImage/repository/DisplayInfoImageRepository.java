package web.boostcourse.api.wba.displayInfoImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.displayInfoImage.model.entity.DisplayInfoImage;
import web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.dto.DisplayInfoImageDtoRepository;
import web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.entity.DisplayInfoImageEntityRepository;

public interface DisplayInfoImageRepository extends JpaRepository<DisplayInfoImage, Long>, DisplayInfoImageEntityRepository, DisplayInfoImageDtoRepository {
}
