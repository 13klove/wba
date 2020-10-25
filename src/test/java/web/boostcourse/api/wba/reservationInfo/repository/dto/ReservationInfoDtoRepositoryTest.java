package web.boostcourse.api.wba.reservationInfo.repository.dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.boostcourse.api.wba.reservationInfo.model.dto.response.RiResponse;
import web.boostcourse.api.wba.reservationInfo.repository.ReservationInfoRepository;

import java.util.List;

@SpringBootTest
public class ReservationInfoDtoRepositoryTest {

    @Autowired
    ReservationInfoRepository reservationInfoRepository;

    @Test
    public void getReservationInfos(){
        List<RiResponse> reservationInfos = reservationInfoRepository.getReservationInfos(1l);
        System.out.println(reservationInfos);
    }

}
