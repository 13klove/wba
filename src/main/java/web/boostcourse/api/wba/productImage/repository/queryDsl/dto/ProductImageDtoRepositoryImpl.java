package web.boostcourse.api.wba.productImage.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.productImage.model.dto.response.ProductImageResponse;
import web.boostcourse.api.wba.productImage.model.dto.response.QProductImageResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.fileInfo.model.entity.QFileInfo.fileInfo;
import static web.boostcourse.api.wba.productImage.model.entity.QProductImage.productImage;

public class ProductImageDtoRepositoryImpl extends CommonRepositoryImpl implements ProductImageDtoRepository {

    public ProductImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ProductImageResponse> getProductImages(Long productId) {
        return getJpaQueryFactory().select(new QProductImageResponse(productImage.product.id, productImage.id, productImage.type
        , fileInfo.id, fileInfo.fileName, fileInfo.saveFileName, fileInfo.contentType, fileInfo.deleteFlag, fileInfo.createDate, fileInfo.modifyDate))
                .from(productImage)
                .join(productImage.fileInfo, fileInfo)
                .where(whereProductId(productId))
                .fetch();
    }

    private BooleanExpression whereProductId(Long productId) {
        return productId==null?null:productImage.id.eq(productId);
    }

}
