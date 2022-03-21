package com.yoondev.backoffice.service;

import com.yoondev.backoffice.repository.BackOfficeRepository;
import com.yoondev.backoffice.utils.OMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BackOfficeService {

    @Autowired
    BackOfficeRepository backOfficeRepository;

    public List<OMap> selectBoardList() {

        return backOfficeRepository.selectBoardList();
    }
}
