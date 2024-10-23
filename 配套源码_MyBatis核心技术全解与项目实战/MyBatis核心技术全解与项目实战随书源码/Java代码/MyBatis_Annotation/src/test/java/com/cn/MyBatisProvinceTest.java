package com.cn;

import com.cn.mapper.ProvinceMapper;
import com.cn.pojo.Province;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Province和City用于演示一对多查询
public class MyBatisProvinceTest {
    // 依据id查询省份方式
    @Test
    public void testFindProvinceById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            ProvinceMapper provinceMapper = sqlSession.getMapper(ProvinceMapper.class);
            int provinceID = 1;
            Province province = provinceMapper.findProvinceById(provinceID);
            System.out.println(province);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
