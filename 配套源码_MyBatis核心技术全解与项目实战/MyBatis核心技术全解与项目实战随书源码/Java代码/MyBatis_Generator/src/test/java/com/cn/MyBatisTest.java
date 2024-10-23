package com.cn;

import com.cn.mapper.WorkerMapper;
import com.cn.pojo.Worker;
import com.cn.pojo.WorkerExample;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.*;

public class MyBatisTest {
    // 测试依据主键id查询工人
    @Test
    public void testSelectWorkerByPrimaryKey() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 工人id
            int id = 1;
            // 依据id查询工人
            Worker worker = workerMapper.selectByPrimaryKey(id);
            // 打印查询结果
            System.out.println(worker);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试查询所有工人
    @Test
    public void testSelectAllWorkerByExample() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 查询所有工人
            List<Worker> workerList = workerMapper.selectByExample(null);
            // 遍历打印查询结果
            Iterator<Worker> iterator = workerList.iterator();
            while (iterator.hasNext()) {
                Worker worker = iterator.next();
                System.out.println(worker);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试根据条件查询工人
    @Test
    public void testSelectWorkerByExample() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建WorkerExample对象
            WorkerExample workerExample = new WorkerExample();
            // 创建Criteria
            WorkerExample.Criteria criteria = workerExample.createCriteria();
            // 设置查询条件
            criteria.andWIdIsNotNull().andWIdGreaterThan(4);
            workerExample.or().andWNameLike("%lu%");
            // 执行查询
            List<Worker> workerList = workerMapper.selectByExample(workerExample);
            // 遍历打印查询结果
            Iterator<Worker> iterator = workerList.iterator();
            while (iterator.hasNext()) {
                Worker worker = iterator.next();
                System.out.println(worker);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试统计满足条件的工人的人数
    @Test
    public void testCountWorkerByExample() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 获取WorkerExample
            WorkerExample workerExample = new WorkerExample();
            // 创建Criteria
            WorkerExample.Criteria criteria = workerExample.createCriteria();
            // 设置查询条件
            criteria.andWIdIsNotNull().andWIdGreaterThan(4);
            workerExample.or().andWNameLike("%lu%");
            // 执行查询
            int count = workerMapper.countByExample(workerExample);
            // 打印查询结果
            System.out.println("满足条件的记录数为"+count);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试依据主键id删除工人
    @Test
    public void testDeleteWorkerByPrimaryKey() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 工人id
            int id = 1;
            // 删除工人
            int result = workerMapper.deleteByPrimaryKey(id);
            // 打印删除结果
            if(result>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试根据条件删除工人
    @Test
    public void testDeleteWorkerByExample() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 获取WorkerExample
            WorkerExample workerExample = new WorkerExample();
            // 创建Criteria
            WorkerExample.Criteria criteria = workerExample.createCriteria();
            // 设置删除条件
            criteria.andWIdLessThan(3);
            workerExample.or().andFIdEqualTo(6);
            // 执行删除
            int result = workerMapper.deleteByExample(workerExample);
            // 打印删除结果
            if(result>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用insert方法插入工人
    @Test
    public void testInsertWorker() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象设置wName属性值
            worker.setwName("yiyi");
            // insert()方法插入工人
            int result = workerMapper.insert(worker);
            // 打印插入结果
            if(result>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用insertSelective方法插入工人
    @Test
    public void testInsertWorkerSelective() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象的wName属性赋值
            worker.setwName("abab");
            // 利用insertSelective()方法插入工人
            int result = workerMapper.insertSelective(worker);
            // 打印插入结果
            if(result>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用updateByPrimaryKey更新工人
    @Test
    public void testUpdateWorkerByPrimaryKey() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象的wId属性赋值
            worker.setwId(4);
            // 为工人对象的wName属性赋值
            worker.setwName("popo");
            // 利用updateByPrimaryKey()方法更新工人
            int result = workerMapper.updateByPrimaryKey(worker);
            // 打印更新结果
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用updateByPrimaryKeySelective更新工人
    @Test
    public void testUpdateWorkerByPrimaryKeySelective() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象的wId属性赋值
            worker.setwId(5);
            // 为工人对象的wName属性赋值
            worker.setwName("kmkm");
            // 利用updateByPrimaryKeySelective()方法更新工人
            int result = workerMapper.updateByPrimaryKeySelective(worker);
            // 打印更新结果
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用updateByExample更新工人
    @Test
    public void testUpdateWorkerByExample() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象的wId属性赋值
            worker.setwId(8);
            // 为工人对象的fId属性赋值
            worker.setfId(2);
            // 为工人对象的wName属性赋值
            worker.setwName("hbhb");
            // 创建WorkerExample
            WorkerExample workerExample = new WorkerExample();
            // 创建Criteria
            WorkerExample.Criteria criteria = workerExample.createCriteria();
            // 设置更新条件
            criteria.andWIdEqualTo(8).andWNameLike("%d%");
            // 利用updateByExample()方法更新工人
            int result = workerMapper.updateByExample(worker,workerExample);
            // 打印更新结果
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用updateByExampleSelective更新工人
    @Test
    public void testUpdateWorkerByExampleSelective() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取WorkerMapper
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            // 创建工人对象
            Worker worker = new Worker();
            // 为工人对象的wId属性赋值
            worker.setwId(9);
            // 为工人对象的fId属性赋值
            worker.setfId(1);
            // 创建WorkerExample
            WorkerExample workerExample = new WorkerExample();
            // 创建Criteria
            WorkerExample.Criteria criteria = workerExample.createCriteria();
            // 设置更新条件
            criteria.andWNameLike("%la%");
            // 利用updateByExampleSelective()方法更新工人
            int result = workerMapper.updateByExampleSelective(worker, workerExample);
            // 打印更新结果
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}