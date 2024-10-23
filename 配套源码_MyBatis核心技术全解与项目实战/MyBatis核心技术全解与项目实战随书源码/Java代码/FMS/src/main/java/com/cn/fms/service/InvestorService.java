package com.cn.fms.service;

import com.cn.fms.pojo.Investor;
import com.cn.fms.pojo.InvestorDto;
import java.util.List;
import java.util.Map;

public interface InvestorService {
    List<Investor> queryByCondition(InvestorDto investorDto);

    int insert(Investor investor);

    Investor queryById(Integer id);

    int update(Investor investor);

    int delete(Integer id);

    List<Map<String, Object>> queryProportionByType(int type);
}
