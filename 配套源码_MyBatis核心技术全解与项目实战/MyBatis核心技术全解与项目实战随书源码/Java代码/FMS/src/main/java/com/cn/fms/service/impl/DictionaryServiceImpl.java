package com.cn.fms.service.impl;

import com.cn.fms.mapper.DictionaryMapper;
import com.cn.fms.pojo.Dictionary;
import com.cn.fms.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    //依据编码查询字典数据
    public List<Dictionary> queryDictionaryByCode(int code) {
        return dictionaryMapper.queryByCode(code);
    }

}
