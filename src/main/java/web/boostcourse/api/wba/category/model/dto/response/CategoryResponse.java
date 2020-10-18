package web.boostcourse.api.wba.category.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
public class CategoryResponse {

    private Long id;

    private String name;

    private Long count;

    @QueryProjection
    public CategoryResponse(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
