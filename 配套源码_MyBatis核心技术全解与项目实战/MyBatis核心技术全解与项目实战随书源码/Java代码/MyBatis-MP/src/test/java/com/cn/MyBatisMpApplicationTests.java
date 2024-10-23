package com.cn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import com.cn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MyBatisMpApplicationTests {

    @Test
    void contextLoads() {
    }

    // 自动注入UserMapper
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById(){
        // 查询id为1的用户
        User user = userMapper.selectById(1);
        // 打印查询结果
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
        ArrayList<Long> idList = new ArrayList<>();
        // 添加第一个用户id
        idList.add(1L);
        // 添加第二个用户id
        idList.add(2L);
        // 添加第三个用户id
        idList.add(3L);
        // 批量查询
        List<User> userList = userMapper.selectBatchIds(idList);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByMap(){
        HashMap<String,Object> hashMap = new HashMap<>();
        // 添加查询条件，即name的值为tome
        hashMap.put("name","tome");
        // 添加查询条件，即age的值为28
        hashMap.put("age",28);
        // 依据条件查询
        List<User> userList = userMapper.selectByMap(hashMap);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectList(){
        // 查询所有用户
        List<User> userList = userMapper.selectList(null);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateById(){
        // 创建User对象
        User user = new User();
        // 设置User对象的id
        user.setId(1L);
        // 设置User对象的name
        user.setName("gugu");
        // 设置User对象的age
        user.setAge(30);
        // 执行更新
        int result = userMapper.updateById(user);
        // 打印更新结果
        if(result>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testInsert1(){
        // 创建User对象
        User user = new User();
        // 设置User对象的id
        user.setId(6L);
        // 设置User对象的name
        user.setName("tutu");
        // 设置User对象的age
        user.setAge(17);
        // 设置User对象的email
        user.setEmail("batj6@ptpress.com");
        // 执行插入
        int result = userMapper.insert(user);
        // 打印插入结果
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testInsert2(){
        // 创建User对象
        User user = new User();
        // 设置User对象的name
        user.setName("dodo");
        // 设置User对象的age
        user.setAge(24);
        // 设置User对象的email
        user.setEmail("batj7@ptpress.com");
        // 执行插入
        int result = userMapper.insert(user);
        // 打印插入结果
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
        // 获取MyBatis-Plus自动生成的雪花ID
        System.out.println("新增用户id="+user.getId());
    }

    @Test
    public void testDeleteById(){
        // 用户id
        Long id = 6L;
        // 删除用户
        int result = userMapper.deleteById(id);
        // 打印删除结果
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testDeleteByMap(){
        // 创建HashMap
        HashMap<String,Object> hashMap = new HashMap<>();
        // 添加删除条件，即name的值为tome
        hashMap.put("name","tome");
        // 添加删除条件，即age的值为28
        hashMap.put("age",28);
        // 执行删除
        int result = userMapper.deleteByMap(hashMap);
        // 打印删除结果
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testDeleteBatchIds(){
        // 创建ArrayList保存用户id
        ArrayList<Long> idList = new ArrayList<>();
        // 添加用户id
        idList.add(1L);
        // 添加用户id
        idList.add(2L);
        // 执行批量删除
        int result = userMapper.deleteBatchIds(idList);
        // 打印删除结果
        if(result>0){
            System.out.println("批量删除成功");
        }else {
            System.out.println("批量删除失败");
        }
    }

    @Test
    public void testQueryWrapper1(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.like("name","ac").lt("age",30);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper2(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.like("name","c").between("age",20,30).isNotNull("email");
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper3(){
        // 创建ArrayList保存用户id
        ArrayList<Long> idList = new ArrayList<>();
        // 添加用户id
        idList.add(1L);
        // 添加用户id
        idList.add(2L);
        // 添加用户id
        idList.add(3L);
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.in("id",idList);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 遍历打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper4(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件并排序
        queryWrapper.orderByDesc("age").orderByAsc("id");
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper5(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.gt("age",20).like("name","a").or().lt("id",3);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper6(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 列名数组
        String[] columnNames = {"name", "age", "email"};
        // 为QueryWrapper设置待查询的列名
        queryWrapper.select(columnNames);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper7(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 列名数组
        String[] columnNames = {"name", "age", "email"};
        // 为QueryWrapper设置待查询的列名
        queryWrapper.select(columnNames);
        // 执行查询
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        // 处理查询结果
        for(Map<String, Object> map:list){
            // 获取Map的EntrySet
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            // 获取EntrySet的迭代器
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            // 迭代变量
            while(iterator.hasNext()){
                // 获取Entry
                Map.Entry<String, Object> entry = iterator.next();
                // 从Entry中获取键
                String key = entry.getKey();
                // Entry中获取值
                Object value = entry.getValue();
                // 打印键与值
                System.out.println(key+"="+value);
            }
        }
    }

    @Test
    public void testQueryWrapper8(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SQL语句
        String sql = "select id from user where id <= 3";
        // 拼接SQL子句
        queryWrapper.inSql("id",sql);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper9(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置模糊查询条件
        String userName = "a";
        // 设置岁数的最小值
        Integer ageBegin = null;
        // 设置岁数的最大值
        Integer ageEnd = 30;
        // 拼接查询条件
        queryWrapper.like(StringUtils.isNotBlank(userName),"name",userName)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectCount(){
        // 创建ArrayList保存用户id
        ArrayList<Long> idList = new ArrayList<>();
        // 添加用户id
        idList.add(1L);
        // 添加用户id
        idList.add(2L);
        // 添加用户id
        idList.add(3L);
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.in("id",idList);
        // 执行统计
       Long count = userMapper.selectCount(queryWrapper);
        // 打印统计结果
        System.out.println("数据总量："+count);
    }

    @Test
    public void testUpdateWrapper1(){
        // 创建User对象
        User user = new User();
        // 设置User对象的名字
        user.setName("lucy");
        // 创建User对象的岁数
        user.setAge(26);
        // 创建UpdateWrapper指定其泛型为User
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // 设置更新条件
        updateWrapper.eq("id",1);
        // 执行更新
        int result = userMapper.update(user, updateWrapper);
        // 打印更新结果
        if(result>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testUpdateWrapper2(){
        // set语句
        String sql = "age = 29 where id<3";
        // 创建UpdateWrapper指定其泛型为User
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // 拼接SQL
        updateWrapper.setSql(sql);
        // 执行更新
        int result = userMapper.update(null,updateWrapper);
        // 打印更新结果
        if(result>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testLambdaQueryWrapper(){
        // 创建LambdaQueryWrapper指定其泛型为User
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 设置模糊查询条件
        String userName = "a";
        // 设置岁数的最小值
        Integer ageBegin = null;
        // 设置岁数的最大值
        Integer ageEnd = 30;
        // 拼接查询条件
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(userName),User::getName,userName)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        // 执行查询
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaUpdateWrapper(){
        // 创建User对象
        User user = new User();
        // 设置User对象的名字
        user.setName("dodo");
        // 创建User对象的岁数
        user.setAge(26);
        // 创建LambdaUpdateWrapper指定其泛型为User
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        // 用户id
        Long userID = 1L;
        // 设置更新条件
        lambdaUpdateWrapper.eq(User::getId,userID);
        // 执行更新
        int result = userMapper.update(user, lambdaUpdateWrapper);
        // 打印更新结果
        if(result>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testFindUserById(){
        // 用户id
        Long userID = 2L;
        // 执行查询
        User user = userMapper.findUserById(userID);
        // 打印查询结果
        System.out.println(user);
    }

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        // 创建User对象
        User user = new User();
        // 设置User对象的id
        user.setId(6L);
        // 设置User对象的name
        user.setName("tutu");
        // 设置User对象的age
        user.setAge(17);
        // 设置User对象的email
        user.setEmail("batj6@ptpress.com");
        // 执行插入操作
        boolean isSuc = userService.save(user);
        // 打印插入结果
        if(isSuc){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }

    @Test
    public void testSaveBatch(){
        // 创建List保存用户
        List<User> userList = new ArrayList<>();
        // 创建第一个User对象
        User user1 = new User(7L,"pipi",18,"batj7@ptpress.com");
        // 将第一个User对象添加至List
        userList.add(user1);
        // 创建第二个User对象
        User user2 = new User(8L,"klkl",19,"batj8@ptpress.com");
        // 将第二个User对象添加至List
        userList.add(user2);
        // 执行批量插入操作
        boolean isSuc = userService.saveBatch(userList);
        // 打印批量插入结果
        if(isSuc){
            System.out.println("批量插入成功");
        }else{
            System.out.println("批量插入失败");
        }
    }

    @Test
    public void testUpdateUserById(){
        // 创建User对象
        User user = new User();
        // 设置User对象的id
        user.setId(6L);
        // 设置User对象的name
        user.setName("btbt");
        // 设置User对象的age
        user.setAge(19);
        // 执行更新
        boolean isSuc = userService.updateById(user);
        // 打印更新结果
        if(isSuc){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }

    @Test
    public void testUpdateBatchById(){
        // 创建List保存用户
        List<User> userList = new ArrayList<>();
        // 创建第一个User对象
        User user1 = new User();
        // 设置用户id
        user1.setId(7L);
        // 设置用户岁数
        user1.setAge(30);
        // 将第一个User对象添加至List
        userList.add(user1);
        // 创建第二个User对象
        User user2 = new User();
        // 设置用户id
        user2.setId(8L);
        // 设置用户岁数
        user2.setAge(33);
        userList.add(user2);
        // 执行批量更新
        boolean isSuc = userService.updateBatchById(userList);
        // 打印批量更新结果
        if(isSuc){
            System.out.println("批量更新成功");
        }else{
            System.out.println("批量更新失败");
        }
    }

    @Test
    public void testGetById(){
        // 用户id
        Long id = 1L;
        // 执行查询
        User user = userService.getById(id);
        // 打印查询结果
        System.out.println(user);
    }

    @Test
    public void testListAll(){
        // 执行查询
        List<User> userList = userService.list();
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }


    @Test
    public void testListByQueryWrapper(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.like("name","ac").lt("age",30);
        // 执行查询
        List<User> userList = userService.list(queryWrapper);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testListUser(){
        // 创建ArrayList保存用户id
        ArrayList<Long> idList = new ArrayList<>();
        // 添加用户id
        idList.add(1L);
        // 添加用户id
        idList.add(2L);
        // 添加用户id
        idList.add(3L);
        // 执行查询
        List<User> userList = userService.listByIds(idList);
        // 打印查询结果
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveOrUpdate(){
        // 创建User对象
        User user = new User();
        // 设置User对象的id
        user.setId(9L);
        // 设置User对象的name
        user.setName("popo");
        // 设置User对象的age
        user.setAge(19);
        // 执行插入或更新
        boolean isSuc = userService.saveOrUpdate(user);
        // 打印插入或更新结果
        if(isSuc){
            System.out.println("插入或更新成功");
        }else{
            System.out.println("插入或更新失败");
        }
    }

    @Test
    public void testRemoveById(){
        String userID = "9";
        // 执行删除
        boolean isSuc = userService.removeById(userID);
        // 打印删除结果
        if(isSuc){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void testRemoveByQueryWrapper(){
        // 创建QueryWrapper指定其泛型为User
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置删除条件
        queryWrapper.like("name","ac").lt("age",30);
        // 执行删除
        boolean isSuc = userService.remove(queryWrapper);
        // 打印删除结果
        if(isSuc){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }


    @Test
    public void testCount(){
        // 执行统计
        long count = userService.count();
        // 打印统计结果
        System.out.println("数据总量："+count);
    }

}
