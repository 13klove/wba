package web.boostcourse.api.wba.reservationUserCommentImage.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.fileInfo.model.entity.FileInfo;
import web.boostcourse.api.wba.reservatioinUserComment.model.entity.ReservationUserComment;
import web.boostcourse.api.wba.reservationInfo.model.entity.ReservationInfo;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "reservation_user_comment_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUserCommentImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "reservation_user_comment_id")
    private ReservationUserComment reservationUserComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "reservation_info_id")
    private ReservationInfo reservationInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "file_info_id")
    private FileInfo fileInfo;

}
