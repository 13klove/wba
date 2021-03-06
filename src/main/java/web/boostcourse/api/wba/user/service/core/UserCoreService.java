package web.boostcourse.api.wba.user.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.config.security.model.JwtHeader;
import web.boostcourse.api.wba.config.security.refreshStore.RefreshStore;
import web.boostcourse.api.wba.config.security.token.JwtTokenProvider;
import web.boostcourse.api.wba.user.model.dto.request.UserParam;
import web.boostcourse.api.wba.user.model.dto.request.UserSearch;
import web.boostcourse.api.wba.user.model.dto.response.UserResponse;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.user.repository.UserRepository;
import web.boostcourse.api.wba.userRole.model.RoleName;
import web.boostcourse.api.wba.userRole.model.entity.UserRole;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserCoreService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefreshStore refreshStore;

    public UserResponse join(UserParam userParam){
        UserRole userRole = UserRole.createUserRole(RoleName.ROLE_USER);
        User user = User.createUser(userParam.getName(), passwordEncoder.encode(userParam.getPassword()), userParam.getEmail(), userParam.getPhone(), userRole);
        userRepository.save(user);
        return UserResponse.builder().email(user.getEmail()).build();
    }

    public void login(UserSearch userSearch, HttpServletResponse response){
        User user = userRepository.findUserByEmail(userSearch.getEmail()).orElseThrow(()->new IllegalArgumentException("없는 이메일입니다."));
        List<String> roles =  user.getUserRoles().stream().map(a->a.getRoleName().toString()).collect(Collectors.toList());

        if(!passwordEncoder.matches(userSearch.getPassword(), user.getPassword())) throw new IllegalArgumentException("잘못된 비밀번호입니다.");

        jwtTokenProvider.createRefreshToken(user.getEmail(), roles);

        JwtHeader token = JwtHeader.builder().token(jwtTokenProvider.createToken(user.getEmail(), roles)).build();
        response.setHeader(token.getKey(), token.getJwtHeader());
    }

    public void getToken(UserSearch userSearch, HttpServletResponse response){
        User user = userRepository.findUserByEmail(userSearch.getEmail()).orElseThrow(()->new IllegalArgumentException("없는 이메일입니다."));
        List<String> roles =  user.getUserRoles().stream().map(a->a.getRoleName().toString()).collect(Collectors.toList());

        JwtHeader token = JwtHeader.builder().token(jwtTokenProvider.getToken(user.getEmail(), roles)).build();
        response.setHeader(token.getKey(), token.getJwtHeader());
    }

}
