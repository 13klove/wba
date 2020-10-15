package web.boostcourse.api.wba.reservationUserCommentImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.reservationUserCommentImage.model.entity.ReservationUserCommentImage;
import web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.dto.ReservationUserCommentImageDtoRepository;
import web.boostcourse.api.wba.reservationUserCommentImage.repository.queryDsl.entity.ReservationUserCommentImageEntityRepository;

public interface ReservationUserCommentImageRepository extends JpaRepository<ReservationUserCommentImage, Long>, ReservationUserCommentImageDtoRepository, ReservationUserCommentImageEntityRepository {
}
