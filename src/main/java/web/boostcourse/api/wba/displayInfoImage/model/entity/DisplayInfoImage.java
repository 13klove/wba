package web.boostcourse.api.wba.displayInfoImage.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.boostcourse.api.wba.displayInfo.model.entity.DisplayInfo;
import web.boostcourse.api.wba.fileInfo.model.entity.FileInfo;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "display_info_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayInfoImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "display_info_id")
    private DisplayInfo displayInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Column(name = "file_id")
    private FileInfo fileInfo;

}
