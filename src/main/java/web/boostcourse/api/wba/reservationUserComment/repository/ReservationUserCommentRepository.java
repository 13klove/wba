package web.boostcourse.api.wba.reservationUserComment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.reservationUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.dto.ReservationUserCommentDtoRepository;
import web.boostcourse.api.wba.reservationUserComment.repository.queryDsl.entity.ReservationUserCommentEntityRepository;

public interface ReservationUserCommentRepository extends JpaRepository<ReservationUserComment, Long>, ReservationUserCommentDtoRepository, ReservationUserCommentEntityRepository {
}
