package web.boostcourse.api.wba.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.user.model.dto.request.UserParam;
import web.boostcourse.api.wba.user.model.dto.request.UserSearch;
import web.boostcourse.api.wba.user.model.dto.response.UserResponse;
import web.boostcourse.api.wba.user.service.core.UserCoreService;

import javax.servlet.http.HttpServletResponse;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserCoreService userCoreService;

    @Transactional
    public UserResponse join(UserParam userParam){
        return userCoreService.join(userParam);
    }

    public void login(UserSearch userSearch, HttpServletResponse response){
        userCoreService.login(userSearch, response);
    }

    public void reissuanceToken(UserSearch userSearch, HttpServletResponse response){
        userCoreService.getToken(userSearch, response);
    }

}
