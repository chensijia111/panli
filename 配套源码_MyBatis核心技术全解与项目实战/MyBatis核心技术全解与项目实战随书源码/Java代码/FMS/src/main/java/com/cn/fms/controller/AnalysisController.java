package com.cn.fms.controller;

import com.cn.fms.service.InvestorService;
import com.cn.fms.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("analysisController")
public class AnalysisController {

    @Autowired
    InvestorService investorService;

    //查询客户
    @RequestMapping(value = "/list")
    public String list() {
//        // 客户级别比例
//        List<Map<String, Object>> levelMap =
//                investorService.queryProportionByType(Constants.LEVEL_TYPE);
//        model.addAttribute("levelMap", levelMap);
//        // 投资领域比例
//        List<Map<String, Object>> fieldMap =
//                investorService.queryProportionByType(Constants.FIELD_TYPE);
//        model.addAttribute("fieldMap", fieldMap);
//        // 投资意向比例
//        List<Map<String, Object>> intentMap =
//                investorService.queryProportionByType(Constants.INTENT_TYPE);
//        model.addAttribute("intentMap", intentMap);

        return "analysis";
    }

    @RequestMapping("/proportion")
    @ResponseBody
    public List<Map<String, Object>> getInvestorProportion(int type) {
        return investorService.queryProportionByType(type);
    }

}
