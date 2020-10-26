package web.boostcourse.api.wba.reservationInfo.service.valid;

import org.springframework.stereotype.Service;
import web.boostcourse.api.wba.displayInfo.valid.DisplayInfoValid;
import web.boostcourse.api.wba.product.valid.ProductValid;
import web.boostcourse.api.wba.productPrice.valid.ProductPriceValid;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.CancelReservationParam;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.RservationInfosParam;
import web.boostcourse.api.wba.reservationInfo.valid.ReservationInfoValid;
import web.boostcourse.api.wba.reservationInfoPrice.valid.ReservationInfoPriceValid;
import web.boostcourse.api.wba.user.valid.UserValid;

@Service
public class ReservationInfoValidService {

    public void reservationInfos(RservationInfosParam reservationInfos){
        ReservationInfoPriceValid.RESERVATION_INFO_PRICE_REQ.validLogic(reservationInfos.getPrices());
        reservationInfos.getPrices().stream().forEach(a->{
            ReservationInfoPriceValid.COUNT.validLogic(a.getCount());
            ProductPriceValid.PRODUCT_PRICE_ID.validLogic(a.getProductPriceId());
        });
        UserValid.USER_ID.validLogic(reservationInfos.getUserId());
        ProductValid.PRODUCT_ID.validLogic(reservationInfos.getProductId());
        DisplayInfoValid.DISPLAY_INFO_ID.validLogic(reservationInfos.getDisplayInfoId());
        ReservationInfoValid.RESERVATION_YEAR_MONTH_DAY.validLogic(reservationInfos.getReservationYearMonthDay());
    }

    public void cancelReservation(CancelReservationParam param){
        ReservationInfoValid.RESERVATION_INFO_ID.validLogic(param.getDisplayInfoId());
    }

}
