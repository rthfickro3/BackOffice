package com.yoondev.backoffice.ctrl;

import com.yoondev.backoffice.service.ManagementService;
import com.yoondev.backoffice.utils.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/management")
public class ManagementController {
    @Autowired
    ManagementService managementService;

    @RequestMapping("/board")
    public String mainIndex(Model model, HttpServletRequest req, @RequestParam HashMap<String, Object> reqParam){
        managementService.selectBoardList(model, req, Util.convertToOMap(reqParam));

        return "/management/board";
    }

    @RequestMapping("/statusChk")
    @ResponseBody
    public String statusChk(){
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("status", "pass");
        jsonResult.put("code", 200);

        return jsonResult.toString();
    }

    @RequestMapping("checkOpenStatus")
    @ResponseBody
    public String checkOpenStatus(Model model){
        managementService.checkOpenStatus(model);
        return (String) model.getAttribute("json");
    }

}
