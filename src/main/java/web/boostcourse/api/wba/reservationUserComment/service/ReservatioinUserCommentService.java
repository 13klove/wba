package web.boostcourse.api.wba.reservationUserComment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentsResponse;
import web.boostcourse.api.wba.reservationUserComment.service.core.ReservatioinUserCommentCoreService;

@Service
@Transactional(readOnly = true)
public class ReservatioinUserCommentService {

    @Autowired
    private ReservatioinUserCommentCoreService reservatioinUserCommentCoreService;

    public ReservationUserCommentsResponse getComments(Long productId, Pageable pageable){
        return reservatioinUserCommentCoreService.getComments(productId, pageable);
    }

}
