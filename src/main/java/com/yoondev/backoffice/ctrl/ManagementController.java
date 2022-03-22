package com.yoondev.backoffice.ctrl;

import com.yoondev.backoffice.service.ManagementService;
import com.yoondev.backoffice.utils.OMap;
import com.yoondev.backoffice.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/management")
public class ManagementController {
    @Autowired
    ManagementService managementService;

    @RequestMapping("/board")
    public String mainIndex(Model model, HttpServletRequest req, @RequestParam HashMap<String, Object> reqParam){
        Boolean success = managementService.selectBoardList(model, req, Util.convertToOMap(reqParam));

        return "/management/board";
    }

}
