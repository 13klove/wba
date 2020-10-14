package web.boostcourse.api.wba.fileInfo.model.entity;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.displayInfoImage.model.entity.DisplayInfoImage;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "file_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileInfo extends BaseDate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private Boolean deleteFlag;

    @OneToMany(mappedBy = "fileInfo")
    private List<ProductImage> productImages = Lists.newArrayList();

    @OneToMany(mappedBy = "fileInfo")
    private List<DisplayInfoImage> displayInfoImages = Lists.newArrayList();

}
