package web.boostcourse.api.wba.category.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.category.model.dto.response.CategorysResponse;
import web.boostcourse.api.wba.category.service.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public CategorysResponse getCategories(){
        return categoryService.getCategories();
    }

}
