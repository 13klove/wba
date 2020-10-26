package web.boostcourse.api.wba.product.valid;

import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

public enum ProductValid {

    PRODUCT_ID("PRODUCT_ID는 필수 값읍니다."){
        @Override
        public void validLogic(Long valud) {
            if(valud==null) throw new ParamValidException(this.getMsg());
        }
    };


    private String msg;

    ProductValid(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void validLogic(Long valud){};

}
