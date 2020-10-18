package web.boostcourse.api.wba.category.repository.queryDsl.dto;

import web.boostcourse.api.wba.category.model.dto.response.CategoryResponse;
import web.boostcourse.api.wba.category.model.dto.response.QCategoryResponse;
import web.boostcourse.api.wba.category.model.entity.QCategory;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.displayInfo.model.entity.QDisplayInfo;
import web.boostcourse.api.wba.product.model.entity.QProduct;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.category.model.entity.QCategory.category;
import static web.boostcourse.api.wba.displayInfo.model.entity.QDisplayInfo.displayInfo;
import static web.boostcourse.api.wba.product.model.entity.QProduct.product;

public class CategoryDtoRepositoryImpl extends CommonRepositoryImpl implements CategoryDtoRepository{

    public CategoryDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return getJpaQueryFactory().select(new QCategoryResponse(category.id, category.name, displayInfo.count()))
                .from(category)
                .leftJoin(category.product, product)
                .leftJoin(product.displayInfos, displayInfo)
                .groupBy(category.id, category.name)
                .fetch();
    }

//    private JPAQueryFactory jpaQueryFactory;
//
//    public CategoryDtoRepositoryImpl(EntityManager entityManager) {
//        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
//    }

}
