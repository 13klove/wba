package web.boostcourse.api.wba.displayInfo.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoDetailResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfosResponse;
import web.boostcourse.api.wba.displayInfo.repository.DisplayInfoRepository;
import web.boostcourse.api.wba.displayInfoImage.model.dto.response.DisplayInfoImageResponse;
import web.boostcourse.api.wba.displayInfoImage.repository.DisplayInfoImageRepository;
import web.boostcourse.api.wba.productImage.model.dto.response.ProductImageResponse;
import web.boostcourse.api.wba.productImage.repository.ProductImageRepository;
import web.boostcourse.api.wba.productPrice.model.dto.response.ProductPriceResponse;
import web.boostcourse.api.wba.productPrice.repository.ProductPriceRepository;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;
import web.boostcourse.api.wba.reservationUserComment.repository.ReservationUserCommentRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DisplayInfoCoreService {

    @Autowired
    private DisplayInfoRepository displayInfoRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private DisplayInfoImageRepository displayInfoImageRepository;
    @Autowired
    private ReservationUserCommentRepository reservationUserCommentRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;

    public DisplayInfosResponse getDisplayInfos(DisplayInfoSearch displayInfoSearch, Pageable pageable){

        Page<DisplayInfoResponse> displayInfoResponses = displayInfoRepository.getDisplayInfos(displayInfoSearch, pageable);
        List<DisplayInfoResponse> content = displayInfoResponses.getContent();

        return DisplayInfosResponse.builder().totalCount(displayInfoResponses.getTotalElements()).productCount(Integer.valueOf(content.size())).products(content).build();
    }

    public DisplayInfoDetailResponse getDisplayInfoDetail(Long displayId){

        DisplayInfoResponse displayInfoDetail = displayInfoRepository.getDisplayInfoDetail(DisplayInfoSearch.builder().displayId(displayId).build());
        List<ProductImageResponse> productImages = productImageRepository.getProductImages(displayInfoDetail.getId());
        List<DisplayInfoImageResponse> displayInfoImage = displayInfoImageRepository.getDisplayInfoImage(displayInfoDetail.getDisplayInfoId());
        ReservationUserCommentResponse avgScore = reservationUserCommentRepository.getAvgScore(displayInfoDetail.getId());
        List<ProductPriceResponse> productPrices = productPriceRepository.getProductPrices(displayInfoDetail.getId());

        return DisplayInfoDetailResponse.builder().product(displayInfoDetail)
                .productImages(productImages)
                .displayInfoImage(displayInfoImage)
                .avgScore(avgScore.getAvgScore())
                .productPrices(productPrices)
                .build();
    }

}
