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
import web.boostcourse.api.wba.reservationInfo.model.dto.request.CancelReservationParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.RservationInfosParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RiResponse;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RisResponse;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationInfo.repository.ReservationInfoRepository;
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
    public ReservationInfo reservationInfos(RservationInfosParam reservationInfos){
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

        return reservationInfoRepository.save(reservationInfo);
    }

    public RisResponse getReservationInfos(Long userId){
        List<RiResponse> reservationInfos = reservationInfoRepository.getReservationInfos(userId);
        return RisResponse.builder().size(reservationInfos.size()).items(reservationInfos).build();
    }

    @Transactional
    public void cancelReservation(CancelReservationParam param){
        ReservationInfo reservationInfo = reservationInfoRepository.getOne(param.getDisplayInfoId());
        reservationInfo.cancelReservation();
    }

}
