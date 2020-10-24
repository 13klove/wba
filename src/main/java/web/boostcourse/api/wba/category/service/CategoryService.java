package web.boostcourse.api.wba.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.category.model.dto.response.CategorysResponse;
import web.boostcourse.api.wba.category.service.core.CategoryCoreService;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    @Autowired
    private CategoryCoreService categoryCoreService;

    public CategorysResponse getCategories(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        return categoryCoreService.getCategories();
    }

}
