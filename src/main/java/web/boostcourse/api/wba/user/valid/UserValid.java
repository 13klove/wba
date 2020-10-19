package web.boostcourse.api.wba.user.valid;

import org.springframework.util.StringUtils;
import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

public enum UserValid {

    EMAIL_LOCK("email을 입력하세요.") {
        public void validLogic(String value){ if(!StringUtils.hasText(value)) throw new ParamValidException("email을 입력하세요."); }
    };

    private String desc;

    UserValid(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void validLogic(String value) { }

}
