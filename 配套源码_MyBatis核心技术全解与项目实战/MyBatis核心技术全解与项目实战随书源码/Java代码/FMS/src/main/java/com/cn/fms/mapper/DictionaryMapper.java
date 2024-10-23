package com.cn.fms.mapper;

import com.cn.fms.pojo.Dictionary;
import java.util.List;

public interface DictionaryMapper {
    //依据编码查询字典数据
    List<Dictionary> queryByCode(int code);
}
