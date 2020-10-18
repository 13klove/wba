package web.boostcourse.api.wba.category.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.boostcourse.api.wba.category.model.dto.response.CategoryResponse;
import web.boostcourse.api.wba.category.repository.CategoryRepository;

import java.util.List;

@SpringBootTest
public class CategoryDtoRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void getCategoriesTest(){
        List<CategoryResponse> categoryResponses = categoryRepository.getCategories();
        System.out.println(categoryResponses);
        Assertions.assertNotNull(categoryResponses);
    }

}
