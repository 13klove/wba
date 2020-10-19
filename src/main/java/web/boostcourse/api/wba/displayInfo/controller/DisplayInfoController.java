package web.boostcourse.api.wba.displayInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoDetailResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfosResponse;
import web.boostcourse.api.wba.displayInfo.service.DisplayInfoService;

@RestController
@RequestMapping("api")
public class DisplayInfoController {

    @Autowired
    private DisplayInfoService displayInfoService;

    @GetMapping("/displayinfos")
    public DisplayInfosResponse getDisplayInfos(DisplayInfoSearch displayInfoSearch, @PageableDefault(size = 4) Pageable pageable){
        return displayInfoService.getDisplayInfos(displayInfoSearch, pageable);
    }

    @GetMapping("/displayinfos/{id}")
    public DisplayInfoDetailResponse getDisplayInfoDetail(@PathVariable("id") Long displayInfoId){
        return displayInfoService.getDisplayInfoDetail(displayInfoId);
    }

}
