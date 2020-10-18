package web.boostcourse.api.wba.category.model.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CategorysResponse {

    private Integer size;

    private List<CategoryResponse> categoryResponses;

}
