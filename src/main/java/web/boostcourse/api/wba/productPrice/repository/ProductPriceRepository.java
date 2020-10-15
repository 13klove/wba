package web.boostcourse.api.wba.productPrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;
import web.boostcourse.api.wba.productPrice.repository.queryDsl.dto.ProductPriceDtoRepository;
import web.boostcourse.api.wba.productPrice.repository.queryDsl.entity.ProductPriceEntityRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long>, ProductPriceDtoRepository, ProductPriceEntityRepository {
}
