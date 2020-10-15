package web.boostcourse.api.wba.userRole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.userRole.model.entity.UserRole;
import web.boostcourse.api.wba.userRole.repository.queryDsl.dto.UserRoleDtoRepository;
import web.boostcourse.api.wba.userRole.repository.queryDsl.entity.UserRoleEntityRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>, UserRoleDtoRepository, UserRoleEntityRepository {
}
