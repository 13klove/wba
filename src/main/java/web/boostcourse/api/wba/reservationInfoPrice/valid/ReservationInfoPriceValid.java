package web.boostcourse.api.wba.reservationInfoPrice.valid;

import web.boostcourse.api.wba.config.exception.domain.ParamValidException;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;

import java.util.List;

public enum ReservationInfoPriceValid {

    RESERVATION_INFO_PRICE_REQ("티켓 선택해주세요"){
        @Override
        public void validLogic(List<ProductPriceRequest.ProductPriceParam> valud) {
            if(valud.isEmpty() || valud == null) throw new ParamValidException(this.getMsg());
        }
    },
    COUNT("티켓은 1장 이상이어야 합니다."){
        @Override
        public void validLogic(Integer valud) {
            if(valud==null||valud==0) throw new ParamValidException(this.getMsg());
        }
    };

    private String msg;

    ReservationInfoPriceValid(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void validLogic(Integer valud){}

    public void validLogic(List<ProductPriceRequest.ProductPriceParam> valud){}

}
