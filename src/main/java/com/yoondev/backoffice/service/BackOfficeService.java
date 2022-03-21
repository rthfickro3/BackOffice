package com.yoondev.backoffice.service;

import com.yoondev.backoffice.repository.BackOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BackOfficeService {

    @Autowired
    BackOfficeRepository backOfficeRepository;

    public List<HashMap<String, Object>> selectBoardList() {

        return backOfficeRepository.selectBoardList();
    }
}
