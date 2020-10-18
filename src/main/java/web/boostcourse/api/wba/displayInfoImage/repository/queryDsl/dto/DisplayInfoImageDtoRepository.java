package web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.dto;

import web.boostcourse.api.wba.displayInfoImage.model.dto.response.DisplayInfoImageResponse;

import java.util.List;

public interface DisplayInfoImageDtoRepository {

    List<DisplayInfoImageResponse> getDisplayInfoImage(Long displayId);

}
