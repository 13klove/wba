package web.boostcourse.api.wba.category.repository.queryDsl.dto;

import web.boostcourse.api.wba.category.model.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryDtoRepository {

    List<CategoryResponse> getCategories();

}
