package web.boostcourse.api.wba.config.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class JwtHeader {

    private final String key = "Authorization";

    private final String refix = "Bearer ";

    private String token;

    public String getJwtHeader(){
        if(token==null) throw new IllegalArgumentException("토큰은 null일 수 없습니다.");
        return refix+token;
    }

}
