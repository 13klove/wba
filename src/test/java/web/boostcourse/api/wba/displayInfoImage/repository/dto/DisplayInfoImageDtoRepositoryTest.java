package web.boostcourse.api.wba.displayInfoImage.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.displayInfoImage.model.dto.response.DisplayInfoImageResponse;
import web.boostcourse.api.wba.displayInfoImage.repository.DisplayInfoImageRepository;

import java.util.List;

@SpringBootTest
public class DisplayInfoImageDtoRepositoryTest {

    @Autowired
    DisplayInfoImageRepository displayInfoImageRepository;

    @Test
    @Transactional
    public void getDisplayInfoImage(){
        List<DisplayInfoImageResponse> displayInfoImage = displayInfoImageRepository.getDisplayInfoImage(1l);
        System.out.println(displayInfoImage);
        Assertions.assertNotEquals(0, displayInfoImage.size());
    }

}
