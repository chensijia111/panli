package com.cn.fms.controller;

import com.cn.fms.pojo.Dictionary;
import com.cn.fms.pojo.Investor;
import com.cn.fms.pojo.InvestorDto;
import com.cn.fms.pojo.Result;
import com.cn.fms.service.InvestorService;
import com.cn.fms.service.DictionaryService;
import com.cn.fms.utils.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("investorController")
@Controller
public class InvestorController {
    @Autowired
    private InvestorService investorService;
    @Autowired
    private DictionaryService dictionaryService;

    //查询客户列表
    @RequestMapping(value = "/list")
    public String list(@RequestParam(required = true, name = "page", defaultValue = "1") Integer page, InvestorDto investorDto, Model model) {
        // 准备客户等级、投资领域、投资意向等数据
        prepareData(model);

        System.out.println("-----------------------");
        if (investorDto != null) {
            System.out.println(investorDto.toString());
        } else {
            System.out.println("investorDto==null");
        }
        System.out.println("-----------------------");

        //保存查询条件至Model便于页面回显数据
        String name = investorDto.getName();
        String levelID = investorDto.getLevelID();
        String fieldID = investorDto.getFieldID();
        String intentID = investorDto.getIntentID();
        model.addAttribute("name", name);
        model.addAttribute("levelID", levelID);
        model.addAttribute("fieldID", fieldID);
        model.addAttribute("intentID", intentID);

        //page:表示查询第几页;8:表示每页显示的数量
        PageHelper.startPage(page, 8);
        List<Investor> investorList = investorService.queryByCondition(investorDto);

        //将customerList封装至PageInfo;5表示分页导航的最大页码数。
        PageInfo<Investor> pageInfo = new PageInfo<Investor>(investorList, 5);
        model.addAttribute("pageInfo", pageInfo);

        return "investor_show";
    }

    @RequestMapping("/toInsert")
    public String toInsert(Model model) {
        // 准备客户等级、投资领域、投资意向等数据
        prepareData(model);
        return "investor_insert";
    }

    //插入客户
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertInvestor(Investor investor, HttpSession session) {
        Result result = new Result();
        long time = System.currentTimeMillis();
        Timestamp timeStamp = new Timestamp(time);
        investor.setCreateTime(timeStamp);
        int rows = investorService.insert(investor);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("新增客户成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("新增客户失败");
        }
        return result;
    }

//    //依据ID查询客户(暂时无用)
//    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
//    @RequestMapping("/queryInvestorById")
//    @ResponseBody
//    public Investor queryInvestorById(Integer id) {
//        Investor investor = investorService.queryById(id);
//        return investor;
//    }

    @RequestMapping("/toUpdate")
    public String toUpdate(int id, Model model) {
        // 准备客户等级、投资领域、投资意向等数据
        prepareData(model);
        Investor investor = investorService.queryById(id);
        model.addAttribute("investor", investor);
        return "investor_update";
    }

    //更新客户
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("/update")
    @ResponseBody
    public Result updateInvestor(Investor investor) {
        Result result = new Result();
        int rows = investorService.update(investor);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("更新客户成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("更新客户失败");
        }
        return result;
    }

    //删除客户
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteInvestor(Integer id) {
        Result result = new Result();
        int rows = investorService.delete(id);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("删除客户成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("删除客户失败");
        }
        return result;
    }

    private void prepareData(Model model){
         // 客户等级
        List<Dictionary> levelList = dictionaryService.queryDictionaryByCode(Constants.LEVEL_TYPE);
        // 投资领域
        List<Dictionary> fieldList = dictionaryService.queryDictionaryByCode(Constants.FIELD_TYPE);
        // 投资意向
        List<Dictionary> intentList = dictionaryService.queryDictionaryByCode(Constants.INTENT_TYPE);
        // 保存数据至Model
        model.addAttribute("levelList", levelList);
        model.addAttribute("fieldList", fieldList);
        model.addAttribute("intentList", intentList);
    }

}
