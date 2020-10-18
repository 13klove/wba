package web.boostcourse.api.wba.productImage.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.boostcourse.api.wba.productImage.model.dto.response.ProductImageResponse;
import web.boostcourse.api.wba.productImage.repository.ProductImageRepository;

import java.util.List;

@SpringBootTest
public class ProductImageDtoRepositoryTest {

    @Autowired
    ProductImageRepository productImageRepository;

    @Test
    @Transactional
    public void getProductImages(){
        List<ProductImageResponse> productImages = productImageRepository.getProductImages(1l);
        System.out.println(productImages);
        Assertions.assertNotEquals(0, productImages.size());
    }

}
