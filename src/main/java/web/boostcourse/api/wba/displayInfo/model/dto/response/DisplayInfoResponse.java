package web.boostcourse.api.wba.displayInfo.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class DisplayInfoResponse {

    private Long id;

    private Long categoryId;

    private Long displayInfoId;

    private String name;

    private String description;

    private String content;

    private String event;

    private String openingHours;

    private String placeName;

    private String placeLot;

    private String placeStreet;

    private String tel;

    private String homepage;

    private String email;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Long fileId;

    @QueryProjection
    public DisplayInfoResponse(Long id, Long categoryId, Long displayInfoId, String name, String description, String content, String event, String openingHours, String placeName, String placeLot, String placeStreet, String tel, String homepage, String email, LocalDateTime createDate, LocalDateTime modifyDate, Long fileId) {
        this.id = id;
        this.categoryId = categoryId;
        this.displayInfoId = displayInfoId;
        this.name = name;
        this.description = description;
        this.content = content;
        this.event = event;
        this.openingHours = openingHours;
        this.placeName = placeName;
        this.placeLot = placeLot;
        this.placeStreet = placeStreet;
        this.tel = tel;
        this.homepage = homepage;
        this.email = email;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.fileId = fileId;
    }

}
