package web.boostcourse.api.wba.displayInfoImage.repository.queryDsl.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.displayInfoImage.model.dto.response.DisplayInfoImageResponse;
import web.boostcourse.api.wba.displayInfoImage.model.dto.response.QDisplayInfoImageResponse;

import javax.persistence.EntityManager;
import java.util.List;

import static web.boostcourse.api.wba.displayInfoImage.model.entity.QDisplayInfoImage.displayInfoImage;
import static web.boostcourse.api.wba.fileInfo.model.entity.QFileInfo.fileInfo;

public class DisplayInfoImageDtoRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoImageDtoRepository {

    public DisplayInfoImageDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<DisplayInfoImageResponse> getDisplayInfoImage(Long displayId) {
        return getJpaQueryFactory().select(new QDisplayInfoImageResponse(displayInfoImage.displayInfo.id, displayInfoImage.id
        , fileInfo.id, fileInfo.fileName, fileInfo.saveFileName, fileInfo.contentType, fileInfo.deleteFlag, fileInfo.createDate, fileInfo.modifyDate))
                .from(displayInfoImage)
                .join(displayInfoImage.fileInfo, fileInfo)
                .where(whereDisplayId(displayId))
                .fetch();
    }

    private BooleanExpression whereDisplayId(Long displayId) {
        return displayId==null?null:displayInfoImage.displayInfo.id.eq(displayId);
    }
}
