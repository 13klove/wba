package web.boostcourse.api.wba.productPrice.repository.queryDsl.dto;

import web.boostcourse.api.wba.productPrice.model.dto.response.ProductPriceResponse;

import java.util.List;

public interface ProductPriceDtoRepository {

    List<ProductPriceResponse> getProductPrices(Long productId);

}
