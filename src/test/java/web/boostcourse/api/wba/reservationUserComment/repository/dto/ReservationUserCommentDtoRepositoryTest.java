package web.boostcourse.api.wba.reservationUserComment.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;
import web.boostcourse.api.wba.reservationUserComment.repository.ReservationUserCommentRepository;

@SpringBootTest
public class ReservationUserCommentDtoRepositoryTest {

    @Autowired
    ReservationUserCommentRepository reservationUserCommentRepository;

    @Test
    @Transactional
    public void getAvgScore(){
        ReservationUserCommentResponse avgScore = reservationUserCommentRepository.getAvgScore(1l);
        System.out.println(avgScore);
        Assertions.assertNotNull(avgScore);
    }

}
