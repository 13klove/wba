package web.boostcourse.api.wba.config.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Data;

import javax.persistence.EntityManager;

@Data
public class CommonRepositoryImpl {

    private JPAQueryFactory jpaQueryFactory;

    public CommonRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

}
