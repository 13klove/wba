package web.boostcourse.api.wba.user.model.dto.request;

import lombok.Data;

@Data
public class UserParam {

    private String name;

    private String password;

    private String email;

    private String phone;

}
