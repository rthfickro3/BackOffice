package com.yoondev.backoffice.repository;

import com.yoondev.backoffice.mapper.BackOfficeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BackOfficeRepository {

    @Autowired
    BackOfficeMapper backOfficeMapper;

    public List<HashMap<String, Object>> selectBoardList() {
        return backOfficeMapper.selectBoardList();
    }
}
