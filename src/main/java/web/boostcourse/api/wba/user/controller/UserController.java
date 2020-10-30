package web.boostcourse.api.wba.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.user.model.dto.request.UserParam;
import web.boostcourse.api.wba.user.model.dto.request.UserSearch;
import web.boostcourse.api.wba.user.model.dto.response.UserResponse;
import web.boostcourse.api.wba.user.service.UserService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public UserResponse join(@RequestBody UserParam userParam){
        return userService.join(userParam);
    }

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody UserSearch userSearch){
        userService.login(userSearch, response);
    }

    @PostMapping("/reissuance")
    public void reissuance(HttpServletResponse response, @RequestBody UserSearch userSearch){
        userService.reissuanceToken(userSearch, response);
    }

}
