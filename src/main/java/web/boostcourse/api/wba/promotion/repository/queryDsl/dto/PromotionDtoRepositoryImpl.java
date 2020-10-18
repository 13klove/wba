package web.boostcourse.api.wba.promotion.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.productImage.model.ImageType;
import web.boostcourse.api.wba.promotion.model.dto.response.PromotionResponse;
import web.boostcourse.api.wba.promotion.model.dto.response.QPromotionResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.category.model.entity.QCategory.category;
import static web.boostcourse.api.wba.product.model.entity.QProduct.product;
import static web.boostcourse.api.wba.productImage.model.entity.QProductImage.productImage;
import static web.boostcourse.api.wba.promotion.model.entity.QPromotion.promotion;

public class PromotionDtoRepositoryImpl extends CommonRepositoryImpl implements PromotionDtoRepository {

    public PromotionDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<PromotionResponse> getPromotions() {
        return getJpaQueryFactory().select(new QPromotionResponse(promotion.id, product.id, category.id, category.name, product.description, productImage.fileInfo.id))
                .from(promotion)
                .join(promotion.product, product)
                .join(promotion.product.category, category)
                .join(promotion.product.productImages, productImage)
                .where(productImagesWhereType(ImageType.ma))
                .fetch();
    }

    private BooleanExpression productImagesWhereType(ImageType ma) {
        return productImage.type.eq(ma);
    }

}
