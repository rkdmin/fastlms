package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entitiy.Category;
import com.zerobase.fastlms.member.entitiy.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryDto {
    private Long id;
    private String categoryName;
    private int sortValue;
    private boolean usingYn;

    // ADD COLUMNS
    int courseCount;

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .sortValue(category.getSortValue())
                .usingYn(category.isUsingYn())
                .build();
    }
}
