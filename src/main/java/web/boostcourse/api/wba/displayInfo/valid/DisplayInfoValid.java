package web.boostcourse.api.wba.displayInfo.valid;

import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

public enum DisplayInfoValid {

    DISPLAY_INFO_ID("DISPLAY_INFO_ID는 필수 값읍니다."){
        @Override
        public void validLogic(Long valud) {
            if(valud==null) throw new ParamValidException(this.getMsg());
        }
    };


    private String msg;

    DisplayInfoValid(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void validLogic(Long valud){};

}
