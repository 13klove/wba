package web.boostcourse.api.wba.displayInfo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DisplayInfoSearch {

    private Long displayId;

    private Long categoryId;

}
