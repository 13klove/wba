package web.boostcourse.api.wba.user.repository.queryDsl.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.StringUtils;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.user.model.entity.User;

import javax.persistence.EntityManager;
import java.util.Optional;

import static web.boostcourse.api.wba.user.model.entity.QUser.user;
import static web.boostcourse.api.wba.userRole.model.entity.QUserRole.userRole;


public class UserEntityRepositoryImpl extends CommonRepositoryImpl implements UserEntityRepository {

    public UserEntityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        User searchUser = getJpaQueryFactory().selectFrom(user)
                .join(user.userRoles, userRole).fetchJoin()
                .where(whereEmail(email))
                .fetchOne();
        return Optional.of(searchUser);
    }

    private BooleanExpression whereEmail(String email) {
        return StringUtils.isEmpty(email)?null:user.email.eq(email);
    }
}
