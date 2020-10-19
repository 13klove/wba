package web.boostcourse.api.wba.displayInfo.repository.queryDsl.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoResponse;

public interface DisplayInfoDtoRepository {

    Page<DisplayInfoResponse> getDisplayInfos(DisplayInfoSearch displayInfoSearch, Pageable pageable);

    DisplayInfoResponse getDisplayInfoDetail(DisplayInfoSearch displayInfoSearch);

}
