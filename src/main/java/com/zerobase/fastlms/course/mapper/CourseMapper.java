package com.zerobase.fastlms.course.mapper;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<CourseDto> selectList(CourseParam parameter);
    long selectListCount(CourseParam parameter);
}
