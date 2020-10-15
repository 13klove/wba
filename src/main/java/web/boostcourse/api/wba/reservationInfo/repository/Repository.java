package web.boostcourse.api.wba.reservationInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.category.model.entity.Category;

public interface Repository extends JpaRepository<Category, Long> {
}
