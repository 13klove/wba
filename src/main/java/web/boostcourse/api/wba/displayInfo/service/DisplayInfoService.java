package web.boostcourse.api.wba.displayInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoDetailResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfosResponse;
import web.boostcourse.api.wba.displayInfo.service.core.DisplayInfoCoreService;


@Service
@Transactional(readOnly = true)
public class DisplayInfoService {

    @Autowired
    private DisplayInfoCoreService displayInfoCoreService;

    public DisplayInfosResponse getDisplayInfos(DisplayInfoSearch displayInfoSearch, Pageable pageable){
        return displayInfoCoreService.getDisplayInfos(displayInfoSearch, pageable);
    }

    public DisplayInfoDetailResponse getDisplayInfoDetail(Long displayId){
        return displayInfoCoreService.getDisplayInfoDetail(displayId);
    }

}
