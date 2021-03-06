package web.boostcourse.api.wba.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.user.repository.queryDsl.dto.UserDtoRepository;
import web.boostcourse.api.wba.user.repository.queryDsl.entity.UserEntityRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserDtoRepository, UserEntityRepository {

}
