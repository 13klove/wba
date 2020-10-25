package web.boostcourse.api.wba.displayInfo.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfoImage.model.entity.DisplayInfoImage;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "display_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayInfo extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String openingHours;

    private String placeName;

    private String placeLot;

    private String placeStreet;

    private String tel;

    private String homepage;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "displayInfo")
    private List<DisplayInfoImage> DisplayInfoImages = Lists.newArrayList();

    @OneToMany(mappedBy = "displayInfo")
    private List<ReservationInfo> reservationInfos = Lists.newArrayList();

    public void addReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfos.add(reservationInfo);
    }
}
