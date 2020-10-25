package web.boostcourse.api.wba.reservationInfo.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.reservationInfoPrice.model.entity.ReservationInfoPrice;
import web.boostcourse.api.wba.reservationUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.reservationUserCommentImage.model.entity.ReservationUserCommentImage;
import web.boostcourse.api.wba.user.model.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "reservation_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationInfo extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private LocalDate reservationDate;

    private Boolean cancelFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "display_info_id")
    private DisplayInfo displayInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservationInfo")
    private List<ReservationUserComment> reservationUserComments = Lists.newArrayList();

    @OneToMany(mappedBy = "reservationInfo")
    private List<ReservationUserCommentImage> reservationUserCommentImages = Lists.newArrayList();

    @OneToMany(mappedBy = "reservationInfo", cascade = CascadeType.ALL)
    private List<ReservationInfoPrice> reservationInfoPrices = Lists.newArrayList();

    public ReservationInfo(LocalDate reservationDate, Boolean cancelFlag) {
        this.reservationDate = reservationDate;
        this.cancelFlag = cancelFlag;
    }

    public ReservationInfo(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public static ReservationInfo createReservationInfo(LocalDate reservationDate, Product product, DisplayInfo displayInfo, User user) {
        ReservationInfo reservationInfo = new ReservationInfo(reservationDate);
        reservationInfo.defaultSet();
        reservationInfo.changeProduct(product);
        reservationInfo.changeDisplayInfo(displayInfo);
        reservationInfo.changeUser(user);
        return reservationInfo;
    }

    public void changeProduct(Product product){
        this.product = product;
        product.addReservationInfo(this);
    }

    public void changeDisplayInfo(DisplayInfo displayInfo){
        this.displayInfo = displayInfo;
        displayInfo.addReservationInfo(this);
    }

    public void changeUser(User user){
        this.user = user;
        user.addReservationInfo(this);
    }

    private void defaultSet() {
        this.cancelFlag = false;
    }

    public void addReservationInfoPrice(List<ReservationInfoPrice> reservationInfoPrices) {
        reservationInfoPrices.forEach(a->{
            this.reservationInfoPrices.add(a);
            a.changeReservationInfo(this);
        });
    }
}
