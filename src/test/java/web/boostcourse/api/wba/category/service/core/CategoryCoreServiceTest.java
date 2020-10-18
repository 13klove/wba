package web.boostcourse.api.wba.category.service.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.boostcourse.api.wba.category.model.dto.response.CategorysResponse;

@SpringBootTest
public class CategoryCoreServiceTest {

    @Autowired
    CategoryCoreService categoryCoreService;

    @Test
    public void getCategories(){
        CategorysResponse categories = categoryCoreService.getCategories();
        System.out.println(categories);
        Assertions.assertNotNull(categories);
    }

}
