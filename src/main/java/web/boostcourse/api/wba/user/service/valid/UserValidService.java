package web.boostcourse.api.wba.user.service.valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.user.model.dto.request.UserParam;
import web.boostcourse.api.wba.user.model.dto.request.UserSearch;

@Service
@Transactional(readOnly = true)
public class UserValidService {

    public void joinValid(UserParam userParam){

    }

    public void loginValid(UserSearch userSearch){

    }

}
