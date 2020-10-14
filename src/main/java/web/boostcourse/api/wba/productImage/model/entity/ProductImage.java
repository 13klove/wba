package web.boostcourse.api.wba.productImage.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.fileInfo.model.entity.FileInfo;
import web.boostcourse.api.wba.product.model.entity.Product;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "product_id")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    @JoinColumn(name = "id")
    @Column(name = "file_id")
    private FileInfo fileInfo;

}
