package web.boostcourse.api.wba.reservationInfo.valid;

import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

import java.time.LocalDate;

public enum ReservationInfoValid {

    RESERVATION_INFO_ID("RESERVATION_INFO_ID는 필수 입니다."){
        @Override
        public void validLogic(Long value) {
            if(value==null) throw new ParamValidException(this.getMsg());
        }
    },
    RESERVATION_YEAR_MONTH_DAY("예약 날은 필수 입니다."){
        @Override
        public void validLogic(LocalDate localDate) {
            if(localDate==null) throw new ParamValidException(this.getMsg());
        }
    };


    private String msg;

    ReservationInfoValid(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void validLogic(LocalDate localDate){};

    public void validLogic(Long value){};

}
