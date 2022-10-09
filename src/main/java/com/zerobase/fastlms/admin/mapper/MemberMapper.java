package com.zerobase.fastlms.admin.mapper;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// xml과 매핑
@Mapper
public interface MemberMapper {
    List<MemberDto> selectList(MemberParam parameter);
}
