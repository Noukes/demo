package com.example.demo.mapper;

import com.example.demo.dto.SearchPreferencesDto;
import com.example.demo.model.SearchPreferences;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SearchPreferencesMapper {
    SearchPreferencesDto toSearchPreferencesDto(SearchPreferences searchPreferences);

    @Mapping(target = "id", ignore = true)
    void updateSearchPreferences(
            @MappingTarget SearchPreferences searchPreferences,
            SearchPreferencesDto searchPreferencesDto);
}
