package com.yoondev.backoffice.repository;

import com.yoondev.backoffice.mapper.BackOfficeMapper;
import com.yoondev.backoffice.utils.OMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BackOfficeRepository {

    @Autowired
    BackOfficeMapper backOfficeMapper;

    public List<OMap> selectBoardList() {
        return backOfficeMapper.selectBoardList();
    }
}
