package web.boostcourse.api.wba.displayInfo.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfoImage.model.entity.DisplayInfoImage;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;
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

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id")
//    @LazyToOne(LazyToOneOption.NO_PROXY)
//    @Column(name = "product_id")
//    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "product_id")
    private List<Product> products = Lists.newArrayList();

    @OneToMany(mappedBy = "displayInfo")
    private List<DisplayInfoImage> DisplayInfoImages = Lists.newArrayList();

    @OneToMany(mappedBy = "reservationInfo")
    private List<ReservationInfo> reservationInfos = Lists.newArrayList();

}
