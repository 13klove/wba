package web.boostcourse.api.wba.displayInfo.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoResponse;
import web.boostcourse.api.wba.displayInfo.repository.DisplayInfoRepository;

@SpringBootTest
public class DisplayInfoRepositoryTest {

    @Autowired
    DisplayInfoRepository displayInfoRepository;

    @Test
    public void getDisplayInfos(){
        DisplayInfoSearch displayInfoSearch = DisplayInfoSearch.builder().categoryId(3l).build();
        PageRequest pageRequest = PageRequest.of(1, 4);

        Page<DisplayInfoResponse> displayInfos = displayInfoRepository.getDisplayInfos(displayInfoSearch, pageRequest);
        Assertions.assertNotNull(displayInfos);
        System.out.println(displayInfos);
        displayInfos.getContent().forEach(a->{
            System.out.println(a.getDescription());
        });
        System.out.println(displayInfos.getContent().size());
    }

    @Test
    @Transactional
    public void getDisplayInfoDetail(){
        DisplayInfoSearch displayInfoSearch = DisplayInfoSearch.builder().displayId(1l).build();
        DisplayInfoResponse displayInfoDetail = displayInfoRepository.getDisplayInfoDetail(displayInfoSearch);
        System.out.println(displayInfoDetail);
        Assertions.assertNotNull(displayInfoDetail);
    }
}
