package web.boostcourse.api.wba.displayInfo.repository.queryDsl.dto;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import web.boostcourse.api.wba.config.querydsl.CommonRepositoryImpl;
import web.boostcourse.api.wba.displayInfo.model.dto.request.DisplayInfoSearch;
import web.boostcourse.api.wba.displayInfo.model.dto.response.DisplayInfoResponse;
import web.boostcourse.api.wba.displayInfo.model.dto.response.QDisplayInfoResponse;

import javax.persistence.EntityManager;

import static web.boostcourse.api.wba.category.model.entity.QCategory.category;
import static web.boostcourse.api.wba.displayInfo.model.entity.QDisplayInfo.displayInfo;
import static web.boostcourse.api.wba.displayInfoImage.model.entity.QDisplayInfoImage.displayInfoImage;
import static web.boostcourse.api.wba.product.model.entity.QProduct.product;

public class DisplayInfoDtoRepositoryImpl extends CommonRepositoryImpl implements DisplayInfoDtoRepository {

    public DisplayInfoDtoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Page<DisplayInfoResponse> getDisplayInfos(DisplayInfoSearch displayInfoSearch, Pageable pageable) {
        QueryResults<DisplayInfoResponse> displayInfoResponseQueryResults = getJpaQueryFactory().select(new QDisplayInfoResponse(product.id, category.id, displayInfo.id, category.name, product.description, product.content, product.event
                , displayInfo.openingHours, displayInfo.placeName, displayInfo.placeLot, displayInfo.placeStreet, displayInfo.tel, displayInfo.homepage, displayInfo.email
                , displayInfo.createDate, displayInfo.modifyDate, displayInfoImage.fileInfo.id))
                .from(category)
                .leftJoin(category.product, product)
                .leftJoin(product.displayInfos, displayInfo)
                .leftJoin(displayInfo.DisplayInfoImages, displayInfoImage)
                .where(whereCategoryId(displayInfoSearch.getCategoryId()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchResults();

        return new PageImpl<>(displayInfoResponseQueryResults.getResults(), pageable, displayInfoResponseQueryResults.getTotal());
    }

    @Override
    public DisplayInfoResponse getDisplayInfoDetail(DisplayInfoSearch displayInfoSearch) {
        return getJpaQueryFactory().select(new QDisplayInfoResponse(product.id, category.id, displayInfo.id, category.name, product.description, product.content, product.event
                , displayInfo.openingHours, displayInfo.placeName, displayInfo.placeLot, displayInfo.placeStreet, displayInfo.tel, displayInfo.homepage, displayInfo.email
                , displayInfo.createDate, displayInfo.modifyDate, displayInfoImage.fileInfo.id))
                .from(category)
                .leftJoin(category.product, product)
                .leftJoin(product.displayInfos, displayInfo)
                .leftJoin(displayInfo.DisplayInfoImages, displayInfoImage)
                .where(whereDisplayId(displayInfoSearch.getDisplayId()))
                .fetchOne();
    }

    private BooleanExpression whereDisplayId(Long displayId) {
        return displayId==null?null:displayInfo.id.eq(displayId);
    }

    private BooleanExpression whereCategoryId(Long categoryId) {
        return categoryId==null?null: category.id.eq(categoryId);
    }
}
