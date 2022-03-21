package com.yoondev.backoffice.mapper;

import com.yoondev.backoffice.utils.OMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BackOfficeMapper {

    List<OMap> selectBoardList();
}
