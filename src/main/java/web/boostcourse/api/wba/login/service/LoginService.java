package web.boostcourse.api.wba.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import web.boostcourse.api.wba.config.security.token.JwtTokenProvider;
import web.boostcourse.api.wba.user.model.dto.request.UserParam;
import web.boostcourse.api.wba.user.model.dto.request.UserSearch;
import web.boostcourse.api.wba.user.model.dto.response.UserResponse;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.user.repository.UserRepository;
import web.boostcourse.api.wba.userRole.model.RoleName;
import web.boostcourse.api.wba.userRole.model.entity.UserRole;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserRepository userRepository;

    public UserResponse join(UserParam userParam){
        UserRole userRole = UserRole.createUserRole(RoleName.ROLE_USER);
        User user = User.createUser(userParam.getName(), userParam.getPassword(), userParam.getEmail(), userParam.getPhone(), userRole);
        userRepository.save(user);
        return UserResponse.builder().email(user.getEmail()).build();
    }

    public String login(@RequestBody UserSearch userSearch){
        User user = userRepository.findUserByEmail(userSearch.getEmail()).orElseThrow(()->new IllegalArgumentException("없는 이메일입니다."));

        if(!passwordEncoder.matches(userSearch.getPassword(), user.getPassword())) throw new IllegalArgumentException("잘못된 비밀번호입니다.");

        return jwtTokenProvider.createToken(user.getEmail(), user.getUserRoles());
    }

}
