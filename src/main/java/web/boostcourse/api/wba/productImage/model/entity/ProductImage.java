package web.boostcourse.api.wba.productImage.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.fileInfo.model.entity.FileInfo;
import web.boostcourse.api.wba.product.model.entity.Product;
import web.boostcourse.api.wba.productImage.model.ImageType;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private ImageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private FileInfo fileInfo;

}
