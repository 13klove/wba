package web.boostcourse.api.wba.reservationInfo.service.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;
import web.boostcourse.api.wba.reservationInfo.model.dto.request.ReservationInfosRequest;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.ReservationInfoDtoResponse;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootTest
public class ReservationInfoCoreServiceTest {

    @Autowired
    ReservationInfoCoreService reservationInfoCoreService;

    @Test
    public void reservationInfosTest(){
        ReservationInfosRequest.RservationInfos build = ReservationInfosRequest.RservationInfos
                .builder()
                .productId(1l)
                .displayInfoId(1l)
                .userId(1l)
                .reservationYearMonthDay(LocalDate.now())
                .prices(Arrays.asList(ProductPriceRequest.ProductPriceParam.builder().count(2).productPriceId(3l).build()))
                .build();

        ReservationInfoDtoResponse.ReservationInfoResponse reservationInfoResponse = reservationInfoCoreService.reservationInfos(build);
        System.out.println(reservationInfoResponse);
    }

}
