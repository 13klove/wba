package web.boostcourse.api.wba.config.security.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
//https://velog.io/@tlatldms/%EC%84%9C%EB%B2%84%EA%B0%9C%EB%B0%9C%EC%BA%A0%ED%94%84-Refresh-JWT-%EA%B5%AC%ED%98%84
public class JwtTokenProvider {

    private String secretKey = "webfirewood";

    private Long tokenValidTime = 30*60*1000l;

    private final UserDetailsService userDetailsService;

    //알고리즘 키 초기화
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //create jwt token
    public String createToken(String userPk, List<String> roles){
        Claims claims = Jwts.claims().setSubject(userPk);
        claims.put("roles", roles);
        Date now = new Date();

        //LocalDateTime로 작업하고 싶지만 setIssueAt가 Date만 받는다.
        return Jwts.builder()
                .setClaims(claims)//정보저장
                .setIssuedAt(now)//토큰 발행 시간
                .setExpiration(new Date(now.getTime()+tokenValidTime))//유효기간
                .signWith(SignatureAlgorithm.HS256, secretKey)//사용할 암호화 알고리즘, 소금
                .compact();
    }

    //jwt search
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //token user info choice
    public String getUserPk(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //request header choice token value ("x-auth-token":"token")
    public String resolveToken(HttpServletRequest request){
        //return request.getHeader("X-AUTH-TOKEN");
        return request.getHeader("Authorization");
    }

    //token valid check
    public Boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }

}
