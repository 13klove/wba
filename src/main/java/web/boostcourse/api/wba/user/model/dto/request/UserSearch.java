package web.boostcourse.api.wba.user.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserSearch {

    private String email;

    private String password;

}
