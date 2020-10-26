package web.boostcourse.api.wba.productPrice.valid;

import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

public enum ProductPriceValid {

    PRODUCT_PRICE_ID("PRDUCT_PRICE_ID가 없습니다."){
        @Override
        public void validLogic(Long valud) {
            if(valud==null) throw new ParamValidException(this.getMsg());
        }
    };

    private String msg;

    ProductPriceValid(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void validLogic(Long valud){};

}
