package web.boostcourse.api.wba.category.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.category.model.dto.response.CategoryResponse;
import web.boostcourse.api.wba.category.model.dto.response.CategorysResponse;
import web.boostcourse.api.wba.category.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryCoreService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategorysResponse getCategories() {
        List<CategoryResponse> categoryResponses = categoryRepository.getCategories();
        return CategorysResponse.builder().size(categoryResponses.size()).categoryResponses(categoryResponses).build();
    }
}
