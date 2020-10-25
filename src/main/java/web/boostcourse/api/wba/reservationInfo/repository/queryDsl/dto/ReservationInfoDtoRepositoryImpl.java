package web.boostcourse.api.wba.reservationInfo.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.QRiResponse;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RiResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.product.model.entity.QProduct.product;
import static web.boostcourse.api.wba.productPrice.model.entity.QProductPrice.productPrice;
import static web.boostcourse.api.wba.reservationInfo.model.entity.QReservationInfo.reservationInfo;
import static web.boostcourse.api.wba.reservationInfoPrice.model.entity.QReservationInfoPrice.reservationInfoPrice;

public class ReservationInfoDtoRepositoryImpl extends CommonRepositoryImpl implements ReservationInfoDtoRepository{

    public ReservationInfoDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<RiResponse> getReservationInfos(Long userId) {
        return getJpaQueryFactory()
                .select(new QRiResponse(reservationInfo.id, reservationInfo.product.id
                        , reservationInfo.displayInfo.id, reservationInfo.cancelFlag
                        , product.description, product.content
                        , reservationInfo.user.id, reservationInfoPrice.count.multiply(productPrice.price)
                , reservationInfo.reservationDate, reservationInfo.createDate, reservationInfo.modifyDate))
                .from(reservationInfo)
                .join(reservationInfo.product, product)
                .join(reservationInfo.reservationInfoPrices, reservationInfoPrice)
                .join(reservationInfoPrice.productPrice, productPrice)
                .where(whereUserId(userId))
                .fetch();
    }

    private BooleanExpression whereUserId(Long userId) {
        return userId==null?null:reservationInfo.user.id.eq(userId);
    }

}
