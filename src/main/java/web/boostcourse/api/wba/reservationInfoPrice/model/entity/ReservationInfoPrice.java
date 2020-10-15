package web.boostcourse.api.wba.reservationInfoPrice.model.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.*;

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

}
