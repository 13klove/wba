package web.boostcourse.api.wba.userRole.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.user.model.entity.User;
import web.boostcourse.api.wba.userRole.model.RoleName;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "user_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
