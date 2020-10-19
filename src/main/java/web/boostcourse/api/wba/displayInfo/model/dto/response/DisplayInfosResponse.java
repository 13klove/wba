package web.boostcourse.api.wba.displayInfo.model.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class DisplayInfosResponse {

    private Long totalCount;

    private Integer productCount;

    private List<DisplayInfoResponse> products;

}
