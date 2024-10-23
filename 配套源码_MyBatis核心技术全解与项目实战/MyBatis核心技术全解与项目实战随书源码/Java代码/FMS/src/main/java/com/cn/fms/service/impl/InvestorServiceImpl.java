package com.cn.fms.service.impl;

import com.cn.fms.pojo.InvestorDto;
import com.cn.fms.service.InvestorService;
import com.cn.fms.mapper.InvestorMapper;
import com.cn.fms.pojo.Investor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service("investorService")
// 事务管理
//@Transactional
public class InvestorServiceImpl implements InvestorService {
	@Autowired
	private InvestorMapper investorMapper;

	// 查询客户列表
	public List<Investor> queryByCondition(InvestorDto investorDto) {
		List<Investor> investorList = investorMapper.queryInvestor(investorDto);
		return investorList;
	}

	//插入客户
	@Override
	public int insert(Investor investor) {
		return investorMapper.insertInvestor(investor);
	}

	//依据ID查询客户
	@Override
	public Investor queryById(Integer id) {
		Investor investor = investorMapper.queryInvestorById(id);
		return investor;
	}

	//更新客户
	@Override
	public int update(Investor investor) {
		return investorMapper.updateInvestor(investor);
	}

	//删除客户
	@Override
	public int delete(Integer id) {
		return investorMapper.deleteInvestor(id);
	}

	@Override
	public List<Map<String, Object>> queryProportionByType(int type) {
		return investorMapper.queryInvestorProportionByType(type);
	}


}
