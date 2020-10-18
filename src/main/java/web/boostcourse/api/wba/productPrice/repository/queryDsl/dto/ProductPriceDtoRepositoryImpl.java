package web.boostcourse.api.wba.productPrice.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.productPrice.model.dto.response.ProductPriceResponse;
import web.boostcourse.api.wba.productPrice.model.dto.response.QProductPriceResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.productPrice.model.entity.QProductPrice.productPrice;

public class ProductPriceDtoRepositoryImpl extends CommonRepositoryImpl implements ProductPriceDtoRepository {

    public ProductPriceDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ProductPriceResponse> getProductPrices(Long productId) {
        return getJpaQueryFactory().select(new QProductPriceResponse(productPrice.id, productPrice.product.id, productPrice.priceTypeName, productPrice.price
        , productPrice.discountRate, productPrice.createDate, productPrice.modifyDate))
                .from(productPrice)
                .where(whereProductId(productId))
                .fetch();
    }

    private BooleanExpression whereProductId(Long productId) {
        return productId==null?null:productPrice.product.id.eq(productId);
    }

}
