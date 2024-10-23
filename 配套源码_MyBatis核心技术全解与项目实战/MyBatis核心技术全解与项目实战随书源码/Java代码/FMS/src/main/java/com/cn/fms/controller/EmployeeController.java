package com.cn.fms.controller;

import com.cn.fms.pojo.Dictionary;
import com.cn.fms.pojo.Employee;
import com.cn.fms.pojo.Result;
import com.cn.fms.service.DictionaryService;
import com.cn.fms.service.EmployeeService;
import com.cn.fms.utils.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("employeeController")
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DictionaryService dictionaryService;

    //登录
    @PostMapping ("login")
    public String login(String name, String password, HttpSession session) {
        Employee employee = employeeService.login(name, password);
        System.out.println(employee);
        if (employee != null) {
            // 清除session中的提示信息
            session.removeAttribute("msg");
            // 保存当前用户至Session
            session.setAttribute("employee", employee);
            session.setAttribute("name", null);
            session.setAttribute("levelID", null);
            session.setAttribute("fieldID", null);
            session.setAttribute("intentID", null);
            // 重定向至客户列表页面
            return "redirect:/investorController/list";
        }
        session.setAttribute("msg", "账号或密码错误，请您重新输入！");
        // 返回至登录页面
        return "login";
    }

    //登出
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        session.removeAttribute("msg");
        // 清除Session
        session.invalidate();
        // 重定向到登录页面
        return "login";
    }

    /**
     * 依据员工名字(用户名或者昵称)和角色ID查询员工
     * 情况1、默认进入员工列表页面时无员工名字和角色ID，所以查询所有
     * 情况2、利用员工名字和角色ID查询时将两者作为查询条件
     *
     * @param page
     * @param name
     * @param roleID
     * @param model
     * @return
     */

    //查询员工列表
    @RequestMapping(value = "list")
    public String employeeList(
            @RequestParam(required = true, name = "page", defaultValue = "1") Integer page,
            @RequestParam(required = true, name = "name", defaultValue = "") String name,
            @RequestParam(required = true, name = "roleID", defaultValue = "") String roleID,
            Model model) {
        // 查询员工角色
        List<Dictionary> roleList =
                dictionaryService.queryDictionaryByCode(Constants.ROLE_TYPE);
        model.addAttribute("roleList", roleList);

        //保存查询条件至Model便于页面回显数据
        model.addAttribute("name", name);
        model.addAttribute("roleID", roleID);

        //page:表示查询第几页;8:表示每页显示的数量
        PageHelper.startPage(page, 8);
        List<Employee> employeeList =
                employeeService.queryByNameAndRole(name, roleID);

        //将userList封装至PageInfo;5表示分页导航的最大页码数。
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList, 5);
        model.addAttribute("pageInfo", pageInfo);

        return "employee_show";
    }

    @RequestMapping("prepareInsert")
    public String prepareInsert(Model model) {
        // 员工角色
        List<Dictionary> roleList =
                dictionaryService.queryDictionaryByCode(Constants.ROLE_TYPE);
        model.addAttribute("roleList", roleList);
        return "employee_insert";
    }

    //插入员工
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("insert")
    @ResponseBody
    public Result insertEmployee(Employee employee) {
        Result result = new Result();
        int rows = employeeService.insert(employee);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("新增员工成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("新增员工失败");
        }
        return result;
    }

//    //依据ID查询员工(暂时无用)
//    @RequestMapping("queryEmployeeById")
//    @ResponseBody
//    public Employee queryEmployeeById(Integer id) {
//        Employee employee = employeeService.queryById(id);
//        return employee;
//    }

    @RequestMapping("prepareUpdate")
    public String prepareUpdate(int id, Model model) {
        Employee employee = employeeService.queryById(id);
        model.addAttribute("employee", employee);

        // 员工角色
        List<Dictionary> roleList =
                dictionaryService.queryDictionaryByCode(Constants.ROLE_TYPE);
        model.addAttribute("roleList", roleList);

        return "employee_update";
    }

    //更新员工
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("update")
    @ResponseBody
    public Result updateEmployee(Employee employee) {
        Result result = new Result();
        int rows = employeeService.update(employee);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("更新员工成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("更新员工失败");
        }
        return result;
    }

    //删除员工
    //利用@ResponseBody将数据以JSON格式返回至AJAX请求
    @RequestMapping("delete")
    @ResponseBody
    public Result deleteEmployee(Integer id) {
        Result result = new Result();
        int rows = employeeService.delete(id);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("删除员工成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("删除员工失败");
        }
        return result;
    }

}
