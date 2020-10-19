//package web.boostcourse.api.wba.login.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import web.boostcourse.api.wba.login.service.LoginService;
//import web.boostcourse.api.wba.user.model.dto.request.UserParam;
//import web.boostcourse.api.wba.user.model.dto.request.UserSearch;
//import web.boostcourse.api.wba.user.model.dto.response.UserResponse;
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    @PostMapping("/join")
//    public UserResponse join(@RequestBody UserParam userParam){
//        return loginService.join(userParam);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody UserSearch userSearch){ return loginService.login(userSearch); }
//
//}
