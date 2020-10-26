package web.boostcourse.api.wba.reservationInfo.service.convert;

import org.springframework.stereotype.Service;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationInfoPrice.model.dto.response.ReservationInfoPriceResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationInfoConvertService {

    public ReservationInfoDtoResponse.ReservationInfoResponse reservationInfoConv(ReservationInfo save) {
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

        List<ReservationInfoPriceResponse.ReservationInfoPriceRes> collect = save.getReservationInfoPrices().stream()
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
