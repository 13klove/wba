package web.boostcourse.api.wba.displayInfo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import web.boostcourse.api.wba.displayInfoImage.model.dto.response.DisplayInfoImageResponse;
import web.boostcourse.api.wba.productImage.model.dto.response.ProductImageResponse;
import web.boostcourse.api.wba.productPrice.model.dto.response.ProductPriceResponse;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DisplayInfoDetailResponse {

    private DisplayInfoResponse product;

    private List<ProductImageResponse> productImages;

    private List<DisplayInfoImageResponse> displayInfoImage;

    private Double avgScore;

    private List<ProductPriceResponse> productPrices;

}
