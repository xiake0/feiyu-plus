package com.modules.common.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.modules.common.entity.DictionaryVal;
import com.modules.common.mapper.DictionaryValMapper;
import com.modules.common.service.DictionaryValService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/15 23:36
 * @Description:
 **/
@Service
public class DictionaryValServiceImpl extends ServiceImpl<DictionaryValMapper,DictionaryVal> implements DictionaryValService{

    @Autowired
    private DictionaryValMapper dictionaryValMapper;

    @Override
    public List<DictionaryVal> getDicByCode(String sex) {
        return dictionaryValMapper.getDicByCode(sex);
    }
}
