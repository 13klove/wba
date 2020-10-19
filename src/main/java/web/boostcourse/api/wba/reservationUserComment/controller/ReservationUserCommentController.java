package web.boostcourse.api.wba.reservationUserComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.reservationUserComment.model.dto.request.ReservationUserCommentSearch;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentsResponse;
import web.boostcourse.api.wba.reservationUserComment.service.ReservatioinUserCommentService;

@RestController
@RequestMapping("api")
public class ReservationUserCommentController {

    @Autowired
    private ReservatioinUserCommentService reservatioinUserCommentService;

    @GetMapping("/comments")
    public ReservationUserCommentsResponse getComments(ReservationUserCommentSearch reservationUserCommentSearch, Pageable pageable){
        return reservatioinUserCommentService.getComments(reservationUserCommentSearch.getProductId(), pageable);
    }

}
