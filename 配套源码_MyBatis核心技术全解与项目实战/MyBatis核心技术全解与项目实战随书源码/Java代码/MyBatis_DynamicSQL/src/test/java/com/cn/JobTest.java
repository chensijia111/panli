package com.cn;

import com.cn.mapper.JobMapper;
import com.cn.mapper.UserMapper;
import com.cn.pojo.Job;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class JobTest {
    @Test
    public void testQueryJobWithIf() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserMapper
            JobMapper jobMapper = sqlSession.getMapper(JobMapper.class);
            // 依据用户名和密码查询用户
            List<Job> jobList = jobMapper.queryJobWithIf("技术",1,"全职","上海");

            // 遍历打印查询结果
            Iterator<Job> iterator = jobList.iterator();
            while (iterator.hasNext()) {
                Job job = iterator.next();
                System.out.println(job);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void testQueryJobWithWhere() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserMapper
            JobMapper jobMapper = sqlSession.getMapper(JobMapper.class);
            // 依据用户名和密码查询用户
            List<Job> jobList = jobMapper.queryJobWithIf("技术",2,"全职","杭州");

            // 遍历打印查询结果
            Iterator<Job> iterator = jobList.iterator();
            while (iterator.hasNext()) {
                Job job = iterator.next();
                System.out.println(job);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
