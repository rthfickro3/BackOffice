package com.yoondev.backoffice.service;

import com.yoondev.backoffice.repository.ManagementRepository;
import com.yoondev.backoffice.utils.HttpUtil;
import com.yoondev.backoffice.utils.OMap;
import com.yoondev.backoffice.utils.Paging;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@Service
public class ManagementService {
    @Autowired
    ManagementRepository managementRepository;

    public Boolean selectBoardList(Model model, HttpServletRequest req, OMap reqParam) {
        OMap dbParams = new OMap();
        int showContentSize = 10;
        int movePage = reqParam.getInt("page", 1);

        int boardListCnt = managementRepository.selectBoardListCount();

        dbParams.put("startLimit", showContentSize * (movePage - 1));
        dbParams.put("endLimit", showContentSize);
        List<OMap> boardList = managementRepository.selectBoardList(dbParams);

        Paging pg = new Paging(showContentSize, boardListCnt, movePage, 8, req.getRequestURI());
        String pagingHTMl = pg.makePagingHTML();

        model.addAttribute("paging", pagingHTMl);
        model.addAttribute("boardList", boardList);

        return true;
    }

    public void checkOpenStatus(Model model){
        try{
            URL url = new URL(HttpUtil.GET_STATUS_CHECK);
            HashMap<String, Object> result = HttpUtil.getApiResult(url);

            JSONObject json = new JSONObject();
            json.put("result", result);

            model.addAttribute("json", json.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
