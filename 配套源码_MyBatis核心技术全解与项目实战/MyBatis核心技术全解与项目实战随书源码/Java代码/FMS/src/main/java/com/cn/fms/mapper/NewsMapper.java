package com.cn.fms.mapper;

import com.cn.fms.pojo.News;
import java.util.List;

public interface NewsMapper {

    List<News> queryNews(String keywords);

    int insertNews(News news);

    News queryNewsById(int id);

    int updateNews(News news);

    int deleteNews(Integer id);
}
