package web.boostcourse.api.wba.user.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.userRole.model.entity.UserRole;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseDate implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;

    private String password;

    private String email;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoles = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ReservationUserComment> reservationUserComments = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ReservationInfo> reservationInfos = Lists.newArrayList();

    public User(String name, String password, String email, String phone, UserRole userRole) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        addUserRole(userRole);
    }

    public static User createUser(String name, String password, String email, String phone, UserRole userRole){
        return new User(name, password, email, phone, userRole);
    }

    public void addUserRole(UserRole userRole){
        this.userRoles.add(userRole);
        userRole.changeUser(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userRoles.stream()
                .map(a->new SimpleGrantedAuthority(a.getRoleName().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
