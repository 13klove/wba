package web.boostcourse.api.wba.productPrice.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.productPrice.model.ProductTypeName;
import web.boostcourse.api.wba.reservationInfoPrice.model.entity.ReservationInfoPrice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@Table(name = "product_price")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductPrice extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductTypeName priceTypeName;

    private Integer price;

    private BigDecimal discountRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "productPrice")
    private List<ReservationInfoPrice> reservationInfoPrices = Lists.newArrayList();

}
