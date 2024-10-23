package com.cn;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.mapper.AccountMapper;
import com.cn.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class MyBatisMpPageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testSelectPage(){
        // 当前页
        int currentPage = 2;
        // 每页数据条数
        int pageSize = 4;
        // 创建Page对象
        Page<Account> page = new Page<>(currentPage,pageSize);
        // 分页查询
        accountMapper.selectPage(page,null);
        // 获取数据总条数
        long total = page.getTotal();
        System.out.println("数据总条数："+total);
        // 获取总页数
        long pages = page.getPages();
        System.out.println("总页数："+pages);
        // 获取当前页所有数据
        List<Account> accountList = page.getRecords();
        // 遍历打印当前页数据
        for (Account account:accountList) {
            System.out.println(account);
        }
        // 判断是否有上一页
        boolean hasPrevious = page.hasPrevious();
        System.out.println("是否有上一页："+hasPrevious);
        // 判断是否有下一页
        boolean hasNext = page.hasNext();
        System.out.println("是否有下一页："+hasNext);
    }

    @Test
    public void testSelectPageByMoney(){
        // 当前页
        int currentPage = 2;
        // 每页数据条数
        int pageSize = 4;
        // 创建Page对象
        Page<Account> page = new Page<>(currentPage,pageSize);
        // 账户余额
        int money = 300;
        // 分页查询
        accountMapper.selectPageByMoney(page,money);
        // 获取数据总条数
        long total = page.getTotal();
        System.out.println("数据总条数："+total);
        // 获取总页数
        long pages = page.getPages();
        System.out.println("总页数："+pages);
        // 获取当前页所有数据
        List<Account> accountList = page.getRecords();
        // 遍历打印当前页数据
        for (Account account:accountList) {
            System.out.println(account);
        }
        // 判断是否有上一页
        boolean hasPrevious = page.hasPrevious();
        System.out.println("是否有上一页："+hasPrevious);
        // 判断是否有下一页
        boolean hasNext = page.hasNext();
        System.out.println("是否有下一页："+hasNext);
    }

    @Test
    public void testOptimisticLocker1() {
        // 账户id
        long accountID = 1L;
        // 第一个人查询账户
        Account account1 = accountMapper.selectById(accountID);
        // 获取账户余额
        Integer money1 = account1.getMoney();
        // 查询记录version
        int version = account1.getVersion();
        System.out.println("第一个人查询到的账户余额为" + money1+"，version为"+version);
        // 第二个查询账户
        Account account2 = accountMapper.selectById(accountID);
        // 获取账户余额
        Integer money2 = account2.getMoney();
        // 查询记录version
        version = account2.getVersion();
        System.out.println("第二个人查询到的账户余额为" + money1+"，version为"+version);

        // 第一个人取钱500
        account1.setMoney(money1 - 500);
        // 更新账户
        int result1 = accountMapper.updateById(account1);
        if (result1 == 0) {
            System.out.println("第一个人取钱500失败");
        } else {
            System.out.println("第一个人取钱500成功");
        }
        // 查询记录version
        version = accountMapper.selectById(accountID).getVersion();
        System.out.println("第一个人取钱结束后该条记录的version为"+version);

        // 第二个人取钱100
        account2.setMoney(money2 - 100);
        // 更新账户
        int result2 = accountMapper.updateById(account2);
        if (result2 == 0) {
            System.out.println("第二个人取钱100失败");
        } else {
            System.out.println("第二个人取钱100成功");
        }
    }

    @Test
    public void testOptimisticLocker2() {
        // 账户id
        long accountID = 1L;
        // 第一个人查询账户
        Account account1 = accountMapper.selectById(accountID);
        // 获取账户余额
        Integer money1 = account1.getMoney();
        // 查询记录version
        int version = account1.getVersion();
        System.out.println("第一个人查询到的账户余额为" + money1+"，version为"+version);
        // 第二个查询账户
        Account account2 = accountMapper.selectById(accountID);
        // 获取账户余额
        Integer money2 = account2.getMoney();
        // 查询记录version
        version = account2.getVersion();
        System.out.println("第二个人查询到的账户余额为" + money1+"，version为"+version);

        // 第一个人取钱500
        account1.setMoney(money1 - 500);
        // 更新账户
        int result1 = accountMapper.updateById(account1);
        if (result1 == 0) {
            System.out.println("第一个人取钱500失败");
        } else {
            System.out.println("第一个人取钱500成功");
        }
        // 查询记录version
        version = accountMapper.selectById(accountID).getVersion();
        System.out.println("第一个人取钱结束后该条记录的version为"+version);

        // 第二个人取钱100
        account2.setMoney(money2 - 100);
        // 更新账户
        int result2 = accountMapper.updateById(account2);
        if (result2 == 0) {
            System.out.println("第二个人取钱100失败");
            System.out.println("第二个人开始重新取钱");
            // 重新获取账户信息
            account2 = accountMapper.selectById(accountID);
            // 获取账户余额
            money2 = account2.getMoney();
            // 查询记录version
            version = account2.getVersion();
            System.out.println("第二个人重新查询到的账户余额为" + money2+"，version为"+version);
            // 第二个人取钱100
            account2.setMoney(money2 - 100);
            // 更新账户
            result2 = accountMapper.updateById(account2);
            if(result2 == 0){
                System.out.println("第二个人重新取钱100失败");
            }else{
                System.out.println("第二个人重新取钱100成功");
            }
        } else {
            System.out.println("第二个人取钱100成功");
        }
    }


}
