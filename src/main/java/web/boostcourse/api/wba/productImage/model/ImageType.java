package web.boostcourse.api.wba.productImage.model;

public enum ImageType {

    th("섬네일"),
    ma("메인"),
    et("기타");

    private String desc;

    ImageType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
