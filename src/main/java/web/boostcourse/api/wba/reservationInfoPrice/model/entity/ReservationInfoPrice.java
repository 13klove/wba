package web.boostcourse.api.wba.reservationInfoPrice.model.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "reservation_info_price")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationInfoPrice {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id")
    private ReservationInfo reservationInfo;

    protected ReservationInfoPrice(Integer count) {
        this.count = count;
    }

    public static List<ReservationInfoPrice> createReservationInfoPrice(List<ProductPriceRequest.ProductPriceParam> prices) {
        return prices.stream().map(a->new ReservationInfoPrice(a.getCount())).collect(Collectors.toList());
    }

    public static ReservationInfoPrice createReservationInfoPrice(Integer count, ProductPrice productPrice) {
        ReservationInfoPrice reservationInfoPrice = new ReservationInfoPrice(count);
        reservationInfoPrice.changeProductPrice(productPrice);
        return reservationInfoPrice;
    }

    public void changeProductPrice(ProductPrice productPrice){
        this.productPrice = productPrice;
        productPrice.addReservationInfoPrice(this);
    }

    public void changeReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }
}
