package com.cn.fms.service;

import com.cn.fms.pojo.News;
import java.util.List;

public interface NewsService {
    News queryById(int id);

    List<News> queryByTitle(String title);

    int insert(News news);

    int update(News news);

    int delete(Integer id);
}
