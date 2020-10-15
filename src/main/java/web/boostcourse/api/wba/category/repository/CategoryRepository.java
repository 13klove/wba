package web.boostcourse.api.wba.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.category.model.entity.Category;
import web.boostcourse.api.wba.category.repository.queryDsl.dto.CategoryDtoRepository;
import web.boostcourse.api.wba.category.repository.queryDsl.entity.CategoryEntityRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryDtoRepository, CategoryEntityRepository {
}
