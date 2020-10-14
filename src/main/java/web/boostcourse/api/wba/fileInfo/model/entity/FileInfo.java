package web.boostcourse.api.wba.fileInfo.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.config.baseDate.BaseDate;
import web.boostcourse.api.wba.productImage.model.entity.ProductImage;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    private ProductImage productImage;

}
