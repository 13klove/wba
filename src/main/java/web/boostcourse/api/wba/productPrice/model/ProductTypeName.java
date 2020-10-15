package web.boostcourse.api.wba.productPrice.model;

public enum ProductTypeName {

    A("성인"),
    Y("청소년"),
    B("유아"),
    S("세트"),
    D("장애인"),
    C("지역주민"),
    E("어얼리버트"),
    V("VIP"),
    R("R석"),
    ;


    private String desc;

    ProductTypeName(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
