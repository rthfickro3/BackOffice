package com.yoondev.backoffice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BackOfficeMapper {

    List<HashMap<String, Object>> selectBoardList();
}
