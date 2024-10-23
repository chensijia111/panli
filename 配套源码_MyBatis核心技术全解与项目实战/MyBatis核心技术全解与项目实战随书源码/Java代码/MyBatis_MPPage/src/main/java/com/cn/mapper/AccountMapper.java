package com.cn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 通过余额查询账户信息并分页
     * @param page 分页对象，该参数必须位于所有参数的最前位置
     * @param money 账户余额
     */
    Page<Account> selectPageByMoney(@Param("page") Page<Account> page, @Param("money") Integer money);
}