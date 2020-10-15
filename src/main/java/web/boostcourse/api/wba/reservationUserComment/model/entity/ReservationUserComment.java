package web.boostcourse.api.wba.reservationUserComment.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;
import web.boostcourse.api.wba.reservationUserCommentImage.model.entity.ReservationUserCommentImage;
import web.boostcourse.api.wba.user.model.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@Table(name = "reservation_user_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUserComment extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private BigDecimal score;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id")
    private ReservationInfo reservationInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservationUserComment")
    private List<ReservationUserCommentImage> reservationUserCommentImages = Lists.newArrayList();

}
