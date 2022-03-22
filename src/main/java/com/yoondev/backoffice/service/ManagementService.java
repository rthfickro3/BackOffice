package com.yoondev.backoffice.service;

import com.yoondev.backoffice.repository.ManagementRepository;
import com.yoondev.backoffice.utils.OMap;
import com.yoondev.backoffice.utils.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ManagementService {
    @Autowired
    ManagementRepository managementRepository;

    public Boolean selectBoardList(Model model, HttpServletRequest req, OMap reqParam) {
        OMap dbParams = new OMap();
        int showContentSize = 10;

        int movePage = reqParam.getInt("page", 1);
        dbParams.put("startLimit", showContentSize * (movePage - 1));
        dbParams.put("endLimit", showContentSize);

        int boardListCnt = managementRepository.selectBoardListCount();

        List<OMap> boardList = managementRepository.selectBoardList(dbParams);

        Paging pg = new Paging(showContentSize, boardListCnt, movePage, 8, req.getRequestURI());
        String pagingHTMl = pg.makePagingHTML();

        model.addAttribute("paging", pagingHTMl);
        model.addAttribute("boardList", boardList);

        return true;
    }
}
