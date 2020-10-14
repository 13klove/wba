package web.boostcourse.api.wba.product.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import web.boostcourse.api.wba.category.model.entity.Category;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;
import web.boostcourse.api.wba.productPrice.model.entity.ProductPrice;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String description;

    private String content;

    private String event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "category_id")
    private Category category;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product", optional = false)
//    @LazyToOne(LazyToOneOption.NO_PROXY)
//    @JoinColumn(name = "product_id")
//    private DisplayInfo displayInfo;
    @OneToMany(mappedBy = "product")
    private List<DisplayInfo> displayInfos = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = Lists.newArrayList();

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices = Lists.newArrayList();

}
