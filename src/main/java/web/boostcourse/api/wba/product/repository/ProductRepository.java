package web.boostcourse.api.wba.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.product.repository.queryDsl.dto.ProductDtoRepository;
import web.boostcourse.api.wba.product.repository.queryDsl.entity.ProductEntityRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductDtoRepository, ProductEntityRepository {
}
