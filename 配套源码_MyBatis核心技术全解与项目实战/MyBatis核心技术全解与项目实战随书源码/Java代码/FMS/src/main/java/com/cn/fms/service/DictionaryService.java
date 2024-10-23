package com.cn.fms.service;

import com.cn.fms.pojo.Dictionary;
import java.util.List;

public interface DictionaryService {
	//依据编码查询字典数据
	List<Dictionary> queryDictionaryByCode(int code);
}
