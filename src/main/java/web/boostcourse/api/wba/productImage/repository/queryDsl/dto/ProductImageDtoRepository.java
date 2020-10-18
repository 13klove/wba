package web.boostcourse.api.wba.productImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.productImage.model.dto.response.ProductImageResponse;

import java.util.List;

public interface ProductImageDtoRepository {

    List<ProductImageResponse> getProductImages(Long productId);

}
