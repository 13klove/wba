package web.boostcourse.api.wba.user.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.reservatioinUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.userRole.model.entity.UserRole;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;

    private String email;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoles = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ReservationUserComment> reservationUserComments = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ReservationInfo> reservationInfos = Lists.newArrayList();

}
