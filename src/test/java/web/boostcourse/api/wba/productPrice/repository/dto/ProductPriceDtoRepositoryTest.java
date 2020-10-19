package web.boostcourse.api.wba.productPrice.repository.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.boostcourse.api.wba.productPrice.model.dto.response.ProductPriceResponse;
import web.boostcourse.api.wba.productPrice.repository.ProductPriceRepository;

import java.util.List;

@SpringBootTest
public class ProductPriceDtoRepositoryTest {

    @Autowired
    ProductPriceRepository productPriceRepository;

    @Test
    public void getProductPrices(){
        List<ProductPriceResponse> productPrices = productPriceRepository.getProductPrices(1l);
        System.out.println(productPrices);
        Assertions.assertNotNull(productPrices);
    }

}
