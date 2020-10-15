package web.boostcourse.api.wba.productImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;
import web.boostcourse.api.wba.productImage.repository.queryDsl.dto.ProductImageDtoRepository;
import web.boostcourse.api.wba.productImage.repository.queryDsl.entity.ProductImageEntityRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long>, ProductImageDtoRepository, ProductImageEntityRepository {
}
