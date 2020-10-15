package web.boostcourse.api.wba.userRole.model;

public enum RoleName {

    ROLE_USER("사용자"),
    ROLE_ADMIN("관리자");

    private String desc;

    RoleName(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
