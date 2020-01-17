package com.modules.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.common.entity.DictionaryVal;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/15 23:35
 * @Description:
 **/
public interface DictionaryValService extends IService<DictionaryVal> {

    List<DictionaryVal> getDicByCode(String code);
}
