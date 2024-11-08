package com.platzi.platzi_market.persistence.mapper;

import com.platzi.platzi_market.domain.Category;
import com.platzi.platzi_market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "productEntities", ignore = true)
    CategoryEntity toCategoryEntity(Category category);
}

