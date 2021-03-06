package web.boostcourse.api.wba.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import web.boostcourse.api.wba.config.security.filter.JwtAuthenticationFilter;
import web.boostcourse.api.wba.config.security.token.JwtTokenProvider;

@EnableWebSecurity
@RequiredArgsConstructor
//https://velog.io/@tlatldms/Spring-boot-Spring-security-JWT-Redis-mySQL-2%ED%8E%B8
//https://mangkyu.tistory.com/57
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                //.cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/login").anonymous()
                .antMatchers("/join").anonymous()
                .antMatchers("/**").permitAll()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //todo
    //cors 사용
    //refresh token 적용
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        //https://icarus8050.tistory.com/28
//        //https://velog.io/@hellozin/Spring-API-%EC%84%9C%EB%B2%84%EC%97%90%EC%84%9C-PUT-DELETE-%EC%9A%94%EC%B2%AD-%EC%8B%9C-CORS-%EC%84%A4%EC%A0%95%EC%9D%B4-%EC%A0%81%EC%9A%A9-%EC%95%88%EB%90%98%EB%8A%94-%EA%B2%BD%EC%9A%B0
    //리플레시토큰
    //https://velog.io/@tlatldms/%EC%84%9C%EB%B2%84%EA%B0%9C%EB%B0%9C%EC%BA%A0%ED%94%84-Refresh-JWT-%EA%B5%AC%ED%98%84
    //https://swalloow.github.io/implement-jwt/
//        //.cors().configurationSource(corsConfigurationSource()).and()
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.addAllowedOrigin("http://localhost:8080");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
