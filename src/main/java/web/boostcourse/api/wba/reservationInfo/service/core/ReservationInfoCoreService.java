package web.boostcourse.api.wba.reservationInfo.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.displayInfo.repository.DisplayInfoRepository;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.product.repository.ProductRepository;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;
import web.boostcourse.api.wba.productPrice.repository.ProductPriceRepository;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.ReservationInfosRequest;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationInfo.repository.ReservationInfoRepository;
import web.boostcourse.api.wba.reservationInfoPrice.model.dto.response.ReservationInfoPriceResponse;
import web.boostcourse.api.wba.reservationInfoPrice.model.entity.ReservationInfoPrice;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ReservationInfoCoreService {

    @Autowired
    private ReservationInfoRepository reservationInfoRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DisplayInfoRepository displayInfoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Transactional
    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfos(ReservationInfosRequest.RservationInfos reservationInfos){
        Product product = productRepository.getOne(reservationInfos.getProductId());
        DisplayInfo displayInfo = displayInfoRepository.getOne(reservationInfos.getDisplayInfoId());
        User user = userRepository.getOne(reservationInfos.getUserId());

        List<ReservationInfoPrice> reservationInfoPrices = reservationInfos.getPrices().stream().map(a -> {
            ProductPrice productPrice = productPriceRepository.getOne(a.getProductPriceId());
            return ReservationInfoPrice.createReservationInfoPrice(a.getCount(), productPrice);
        }).collect(Collectors.toList());

        ReservationInfo reservationInfo = ReservationInfo
                .createReservationInfo(reservationInfos.getReservationYearMonthDay(), product, displayInfo, user);
        reservationInfo.addReservationInfoPrice(reservationInfoPrices);

        ReservationInfo save = reservationInfoRepository.save(reservationInfo);

        return reservationInfoConv(reservationInfoPrices, save);
    }

    private ReservationInfoDtoResponse.ReservationInfoResponse reservationInfoConv(List<ReservationInfoPrice> reservationInfoPrices, ReservationInfo save) {
        ReservationInfoDtoResponse.ReservationInfoResponse build = ReservationInfoDtoResponse.ReservationInfoResponse
                .builder()
                .id(save.getId())
                .productId(save.getProduct().getId())
                .cancelFlag(save.getCancelFlag())
                .displayInfoId(save.getDisplayInfo().getId())
                .userId(save.getUser().getId())
                .reservationDate(save.getReservationDate())
                .createDate(save.getCreateDate())
                .modifyDate(save.getModifyDate())
                .build();

        List<ReservationInfoPriceResponse.ReservationInfoPriceRes> collect = reservationInfoPrices.stream()
                .map(a ->
                        ReservationInfoPriceResponse.ReservationInfoPriceRes.builder()
                                .id(a.getId())
                                .reservationInfoId(a.getReservationInfo().getId())
                                .productPriceId(a.getProductPrice().getId())
                                .count(a.getCount())
                                .build()
                ).collect(Collectors.toList());
        build.setPrices(collect);
        return build;
    }

}
