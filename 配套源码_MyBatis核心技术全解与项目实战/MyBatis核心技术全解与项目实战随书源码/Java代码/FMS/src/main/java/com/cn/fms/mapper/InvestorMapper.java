package com.cn.fms.mapper;

import com.cn.fms.pojo.Investor;
import com.cn.fms.pojo.InvestorDto;
import java.util.List;
import java.util.Map;

public interface InvestorMapper {
    //查询客户列表
    List<Investor> queryInvestor(InvestorDto investorDto);

    //插入客户
    int insertInvestor(Investor investor);

    //依据ID查询客户
    Investor queryInvestorById(Integer id);

    //更新客户
    int updateInvestor(Investor investor);

    //删除客户
    int deleteInvestor(Integer id);

    List<Map<String, Object>> queryInvestorProportionByType(int type);
}
