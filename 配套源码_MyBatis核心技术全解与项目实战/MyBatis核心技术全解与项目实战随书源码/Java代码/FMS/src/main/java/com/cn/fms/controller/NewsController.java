package com.cn.fms.controller;

import com.cn.fms.pojo.Employee;
import com.cn.fms.pojo.News;
import com.cn.fms.pojo.Result;
import com.cn.fms.service.NewsService;
import com.cn.fms.utils.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("newsController")
public class NewsController {
    @Autowired
    NewsService newsService;

    //查询新闻列表
    @RequestMapping(value = "list")
    public String newsList(
           @RequestParam(required=true,name="page",defaultValue="1")Integer page,
           @RequestParam(required=false,name="title",defaultValue="")String title, Model model) {
        //保存查询条件至Model便于页面回显数据
        model.addAttribute("title", title);

        //page:表示查询第几页;8:表示每页显示的数量
        PageHelper.startPage(page, 8);
        List<News> newsList = newsService.queryByTitle(title);
        System.out.println(newsList);
        //将newsList封装至PageInfo;5表示分页导航的最大页码数。
        PageInfo<News> pageInfo = new PageInfo<News>(newsList, 5);
        model.addAttribute("pageInfo", pageInfo);

        return "news_show";
    }

    @RequestMapping("prepareInsert")
    public String prepareInsert(Model model) {
        return "news_insert";
    }

    /**
     * 图片上传
     *
     * @param file 图片
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadPhoto(MultipartFile file, HttpServletRequest request, Result result) {
        String originalFileName = file.getOriginalFilename();
        if (file == null || !StringUtils.hasLength(originalFileName)) {
            result.setStatus(Constants.ERROR);
            result.setDescription("请选择要上传的图片！");
            return result;
        }
        if (file.getSize() > 1024 * 1024 * 5) {
            result.setStatus(Constants.ERROR);
            result.setDescription("图片大小不能超过5M！");
            return result;
        }
        //获取文件后缀
        int beginIndex = originalFileName.lastIndexOf(".") + 1;
        int endIndex = originalFileName.length();
        String suffix = originalFileName.substring(beginIndex, endIndex);
        if (!"jpg,jpeg,gif,png".contains(suffix)) {
            result.setStatus(Constants.ERROR);
            result.setDescription("请选择jpg,jpeg,gif,png格式的图片！");
            return result;
        }
        // 图片上传目录
        String uploadDirPath = "src/main/resources/static/upload";
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            //若不存在该目录，则创建目录
            uploadDir.mkdirs();
        }

        String fileName = new Date().getTime() + "." + suffix;
        // 保存至数据库的图片路径
        String imagePath = "/static/upload" + File.separator + fileName;
        try {
            String canonicalPath = uploadDir.getCanonicalPath();
            File imageFile = new File(canonicalPath+File.separator+fileName);
            file.transferTo(imageFile);
        } catch (Exception e) {
            result.setStatus(Constants.ERROR);
            result.setDescription("保存文件异常！");
            e.printStackTrace();
            return result;
        }
        result.setStatus(Constants.OK);
        result.setDescription("图片上传成功！");
        result.setData(imagePath);
        return result;
    }

    @RequestMapping("insertNews")
    @ResponseBody
    public Result insertNews(News news, HttpSession session, Result result) {
        // 获取当前登录的用户
        Employee employee = (Employee) session.getAttribute("employee");
        Integer id = employee.getId();
        news.setPublisher(id + "");

        int rows = newsService.insert(news);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("新增新闻成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("新增新闻失败");
        }
        return result;
    }


    @RequestMapping("prepareUpdate")
    public String prepareUpdate(int id, Model model) {
        News news = newsService.queryById(id);
        model.addAttribute("news", news);
        return "news_update";
    }

    @RequestMapping("updateNews")
    @ResponseBody
    public Result updateNews(News news, Result result) {
        System.out.println(news);
        int rows = newsService.update(news);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("更新新闻成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("更新新闻失败");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result deleteNews(Integer id) {
        Result result = new Result();
        int rows = newsService.delete(id);
        if (rows > 0) {
            result.setStatus(Constants.OK);
            result.setDescription("删除新闻成功");
        } else {
            result.setStatus(Constants.ERROR);
            result.setDescription("删除新闻失败");
        }
        return result;
    }

    @RequestMapping("detail")
    public String showNews(int id, Model model) {
        News news = newsService.queryById(id);
        model.addAttribute("news", news);
        return "news_detail";
    }

}
