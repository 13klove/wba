package web.boostcourse.api.wba.reservationInfo.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class RiResponse {

    private Long id;

    private Long productId;

    private Long displayInfoId;

    private Boolean cancelFlag;

    private String productDescription;

    private String productContent;

    private Long userId;

    private Integer sumPrice;

    private LocalDate reservationDate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @QueryProjection
    public RiResponse(Long id, Long productId, Long displayInfoId, Boolean cancelFlag, String productDescription, String productContent, Long userId, Integer sumPrice, LocalDate reservationDate, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.cancelFlag = cancelFlag;
        this.productDescription = productDescription;
        this.productContent = productContent;
        this.userId = userId;
        this.sumPrice = sumPrice;
        this.reservationDate = reservationDate;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
