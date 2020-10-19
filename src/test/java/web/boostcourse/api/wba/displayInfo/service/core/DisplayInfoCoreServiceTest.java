package web.boostcourse.api.wba.displayInfo.service.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoDetailResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfosResponse;

@SpringBootTest
public class DisplayInfoCoreServiceTest {

    @Autowired
    DisplayInfoCoreService displayInfoCoreService;

    @Test
    public void getDisplayInfos(){
        DisplayInfoSearch displayInfoSearch = DisplayInfoSearch.builder().categoryId(3l).build();
        PageRequest page = PageRequest.of(1, 4);
        DisplayInfosResponse displayInfos = displayInfoCoreService.getDisplayInfos(displayInfoSearch, page);

        System.out.println(displayInfos);
        Assertions.assertNotNull(displayInfos);
    }

    @Test
    public void getDisplayInfoDetail(){
        DisplayInfoDetailResponse displayInfoDetail = displayInfoCoreService.getDisplayInfoDetail(1l);
        System.out.println(displayInfoDetail);
        Assertions.assertNotNull(displayInfoDetail);
    }

}
