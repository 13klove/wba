package web.boostcourse.api.wba.user.valid;

import org.springframework.util.StringUtils;
import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

public enum UserValid {

    USER_ID("USER_ID는 필수 값읍니다."){
        @Override
        public void validLogic(Long value) {
            if(value==null) throw new ParamValidException(this.getDesc());
        }
    },
    EMAIL_LOCK("email을 입력하세요.") {
        public void validLogic(String value){ if(!StringUtils.hasText(value)) throw new ParamValidException(this.getDesc()); }
    };

    private String desc;

    UserValid(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void validLogic(String value) { }

    public void validLogic(Long value) { }

}
