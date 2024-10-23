package com.cn.fms.service.impl;

import com.cn.fms.mapper.NewsMapper;
import com.cn.fms.pojo.News;
import com.cn.fms.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("newsService")
// 事务管理
//@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> queryByTitle(String title) {
        return newsMapper.queryNews(title);
    }

    @Override
    public int insert(News news) {
        return newsMapper.insertNews(news);
    }

    @Override
    public News queryById(int id) {
        return newsMapper.queryNewsById(id);
    }

    @Override
    public int update(News news) {
        return newsMapper.updateNews(news);
    }

    @Override
    public int delete(Integer id) {
        return newsMapper.deleteNews(id);
    }
}
