package web.boostcourse.api.wba.reservationUserComment.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentResponse;
import web.boostcourse.api.wba.reservationUserComment.model.dto.response.ReservationUserCommentsResponse;
import web.boostcourse.api.wba.reservationUserComment.repository.ReservationUserCommentRepository;
import web.boostcourse.api.wba.reservationUserCommentImage.model.dto.response.ReservationUserCommentImageResponse;
import web.boostcourse.api.wba.reservationUserCommentImage.repository.ReservationUserCommentImageRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ReservatioinUserCommentCoreService {

    @Autowired
    private ReservationUserCommentRepository reservationUserCommentRepository;
    @Autowired
    private ReservationUserCommentImageRepository reservationUserCommentImageRepository;

    public ReservationUserCommentsResponse getComments(Long productId, Pageable pageable){
        Page<ReservationUserCommentResponse> pageComment = reservationUserCommentRepository.getComments(productId, pageable);
        List<ReservationUserCommentResponse> comment = pageComment.getContent();

        List<Long> reservationUserCommentIds = comment.stream().map(a -> a.getId()).collect(Collectors.toList());
        Map<Long, List<ReservationUserCommentImageResponse>> rservationUserCommentImages =
                reservationUserCommentImageRepository.getRservationUserCommentImages(reservationUserCommentIds)
                        .stream()
                        .collect(Collectors.groupingBy(a->a.getReservationUserCommentId()));

        comment.forEach(a->a.setReservationUserCommentImages(rservationUserCommentImages.get(a.getId())));

        return ReservationUserCommentsResponse.builder().totalCount(pageComment.getTotalElements())
                .commentCount(Integer.valueOf(comment.size()))
                .reservationUserComments(comment)
                .build();
    }

}
