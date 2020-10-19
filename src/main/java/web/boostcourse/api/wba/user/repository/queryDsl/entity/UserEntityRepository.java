package web.boostcourse.api.wba.user.repository.queryDsl.entity;

import web.boostcourse.api.wba.user.model.entity.User;

import java.util.Optional;

public interface UserEntityRepository {

    Optional<User> findUserByEmail(String email);

}
