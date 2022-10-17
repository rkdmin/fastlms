package com.zerobase.fastlms.admin.mapper;


import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.course.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    List<BannerDto> select(BannerDto parameter);

    long selectListCount();

    List<BannerDto> selectList();
}
