package web.boostcourse.api.wba.displayInfo.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "product_id")
    private Product product;

}
