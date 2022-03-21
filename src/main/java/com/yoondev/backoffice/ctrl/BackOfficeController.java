package com.yoondev.backoffice.ctrl;

import com.yoondev.backoffice.service.BackOfficeService;
import com.yoondev.backoffice.utils.OMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class BackOfficeController {
    @Autowired
    BackOfficeService backOfficeService;

    @RequestMapping("/")
    public String mainIndex(Model model){
        List<OMap> boardList = backOfficeService.selectBoardList();

        model.addAttribute("boardList", boardList);
        return "/management/board";
    }

}
