package com.zerobase.fastlms.course.service;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;

import java.util.List;

public interface CourseService{
    /**
     * 강좌 등록
     */
    boolean add(CourseInput parameter);

    /**
     * 강좌 목록
     */
    List<CourseDto> list(CourseParam parameter);

    /**
     * 강좌 상세 정보
     */
    CourseDto getBtId(long id);

    /**
     * 강좌 정보 수정
     */
    boolean set(CourseInput parameter);

    /**
     * 강좌 내용 삭제
     */
    boolean delete(String idList);

    /**
     * 강좌 목록(프론트)
     */
    List<CourseDto> frontList(CourseParam parameter);

    /**
     * 강좌 상세 정보(프론트)
     */
    CourseDto frontDetail(long id);

    /**
     * 수강 신청
     */
    ServiceResult req(TakeCourseInput parameter);
}
