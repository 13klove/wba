package web.boostcourse.api.wba.product.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import web.boostcourse.api.wba.category.model.entity.Category;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;
import web.boostcourse.api.wba.promotion.model.entity.Promotion;
import web.boostcourse.api.wba.reservationUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String description;

    private String content;

    private String event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Promotion> promotions = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ReservationUserComment> reservationUserComments = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<DisplayInfo> displayInfos = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ReservationInfo> reservationInfos = Lists.newArrayList();

}
