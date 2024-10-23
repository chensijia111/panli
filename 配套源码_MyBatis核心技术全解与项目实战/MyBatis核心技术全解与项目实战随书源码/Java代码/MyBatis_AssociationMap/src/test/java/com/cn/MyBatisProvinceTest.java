package com.cn;

import com.cn.mapper.ProvinceMapper;
import com.cn.pojo.Province;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//Province和City用于演示一对多查询
public class MyBatisProvinceTest {
    // 依据id查询省份方式1
    @Test
    public void testFindProvinceById1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取ProvinceMapper
            ProvinceMapper provinceMapper = sqlSession.getMapper(ProvinceMapper.class);
            // 省份id
            int provinceID = 1;
            // 查询省份
            Province province = provinceMapper.findProvinceById1(provinceID);
            // 打印省份信息
            System.out.println(province);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
    // 依据id查询省份方式2
    @Test
    public void testFindProvinceById2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取ProvinceMapper
            ProvinceMapper provinceMapper = sqlSession.getMapper(ProvinceMapper.class);
            // 省份id
            int provinceID = 1;
            // 查询省份
            Province province = provinceMapper.findProvinceById2(provinceID);
            // 打印省份信息
            System.out.println(province);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void testFindProvinceById3(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取ProvinceMapper
            ProvinceMapper provinceMapper = sqlSession.getMapper(ProvinceMapper.class);
            // 省份id
            int provinceID = 1;
            // 查询省份
            Province province = provinceMapper.findProvinceById2(provinceID);
            // 打印省份信息
            System.out.println(province);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
