package com.yoondev.backoffice.repository;

import com.yoondev.backoffice.mapper.ManagementMapper;
import com.yoondev.backoffice.utils.OMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ManagementRepository {
    @Autowired
    ManagementMapper managementMapper;

    public int selectBoardListCount() { return managementMapper.selectBoardListCount(); }

    public List<OMap> selectBoardList(OMap dbParams) {
        return managementMapper.selectBoardList(dbParams);
    }
}
