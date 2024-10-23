package com.cn;

import com.cn.mapper.PhoneMapper;
import com.cn.pojo.Phone;
import com.cn.util.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testQueryAllPhone(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取PhoneMapper
            PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
            // 开启分页功能。每页6条数据，查询第4页的数据。
            PageHelper.startPage(4, 6);
            // 执行分页查询
            List<Phone> list = phoneMapper.queryAllPhone();
            // 打印查询结果
            for(Phone phone:list){
                System.out.println(phone);
            }
            // 创建分页，导航条中有5个导航页面
            PageInfo<Phone> pageInfo = new PageInfo<>(list,5);
            // 获取分页详情
            long total = pageInfo.getTotal();
            System.out.println("数据总条数: " + total);
            int pages = pageInfo.getPages();
            System.out.println("总页数: " + pages);
            int pageSize = pageInfo.getPageSize();
            System.out.println("每页数据条数: " + pageSize);
            int navigatePages = pageInfo.getNavigatePages();
            System.out.println("导航页数量:"+navigatePages);
            int[] navigatePageNums = pageInfo.getNavigatepageNums();
            System.out.println("所有导航页码:"+ Arrays.toString(navigatePageNums));
            int navigateFirstPage = pageInfo.getNavigateFirstPage();
            System.out.println("导航起始页码: " + navigateFirstPage);
            int navigateLastPage = pageInfo.getNavigateLastPage();
            System.out.println("导航终止页码: " + navigateLastPage);
            int pageNum = pageInfo.getPageNum();
            System.out.println("当前页码: " + pageNum);
            boolean isFirstPage = pageInfo.isIsFirstPage();
            System.out.println("当前页是否是第一页: " + isFirstPage);
            boolean isLastPage = pageInfo.isIsLastPage();
            System.out.println("当前页是否是最后一页: " + isLastPage);
            boolean hasPreviousPage = pageInfo.isHasPreviousPage();
            System.out.println("当前页是否有上一页: " + hasPreviousPage);
            boolean hasNextPage = pageInfo.isHasNextPage();
            System.out.println("当前页是否有下一页: " + hasNextPage);
            int prePage = pageInfo.getPrePage();
            System.out.println("当前页上一页的页码：" + prePage);
            int nextPage = pageInfo.getNextPage();
            System.out.println("当前页下一页的页码：" + nextPage);
            int size = pageInfo.getSize();
            System.out.println("当前页数据的条数: " + size);
            long startRow = pageInfo.getStartRow();
            System.out.println("当前页第一个元素在数据表中的行号: " + startRow);
            long endRow = pageInfo.getEndRow();
            System.out.println("当前页最后一个元素在数据表中的行号: " + endRow);
            // 获取当前页数据
            List<Phone> phoneList = pageInfo.getList();
            System.out.println("当前页每条数据如下：");
            // 打印当前页数据
            for(Phone phone:phoneList){
                System.out.println(phone);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
