package com.cn;

import com.cn.mapper.UserSkillMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisSkillTest {

    @Test
    public void testInsertUserGetID1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserSkillMapper
            UserSkillMapper userSkillMapper = sqlSession.getMapper(UserSkillMapper.class);
            // 创建用户对象
            User user = new User(null, "nini", "222666", "female");
            // 插入用户
            int insertResult = userSkillMapper.insertUserGetID1(user);
            System.out.println(insertResult);
            // 获取用户id
            Integer id = user.getId();
            // 打印用户id
            System.out.println("执行插入操作后获得自动生成的主键id="+id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertUserGetID2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserSkillMapper
            UserSkillMapper userSkillMapper = sqlSession.getMapper(UserSkillMapper.class);
            // 创建用户对象
            User user = new User(null, "kpkp", "111999", "female");
            // 插入用户
            int insertResult = userSkillMapper.insertUserGetID1(user);
            System.out.println(insertResult);
            // 获取用户id
            Integer id = user.getId();
            // 打印用户id
            System.out.println("执行插入操作后获得自动生成的主键id="+id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserSkillMapper
            UserSkillMapper userSkillMapper = sqlSession.getMapper(UserSkillMapper.class);
            // 表名
            String tableName = "user";
            // 查询表的记录总数
            Integer count = userSkillMapper.getCount(tableName);
            // 打印记录总数
            System.out.println("表中的记录总数 = "+count);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserSkillMapper
            UserSkillMapper userSkillMapper = sqlSession.getMapper(UserSkillMapper.class);
            // 用户id
            String ids = "7,8,9";
            // 批量删除用户
            Integer count = userSkillMapper.deleteMore(ids);
            System.out.println("被删除的用户数量 = "+count);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
