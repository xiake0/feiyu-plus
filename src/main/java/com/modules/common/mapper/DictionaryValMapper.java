package com.modules.common.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.modules.common.entity.DictionaryVal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/15 23:33
 * @Description:
 **/
public interface DictionaryValMapper extends BaseMapper<DictionaryVal> {

    @Select("SELECT t2.id,t2.name,t2.value,t2.del_flag FROM t_dictionary t1,t_dictionary_val t2" +
            " WHERE t1.id=t2.dictionary_id AND t1.code=#{code}")
    List<DictionaryVal> getDicByCode(@Param(value = "code") String code);
}
