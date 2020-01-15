package com.modules.common.controller;

import com.common.utils.ResultUtil;
import com.common.vo.Result;
import com.modules.common.entity.DictionaryVal;
import com.modules.common.service.DictionaryValService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/15 23:00
 * @Description:
 **/
@RestController
@RequestMapping("/common/dictionary")
@Api(value = "字典管理")
public class DictionaryController {

    @Autowired
    private DictionaryValService dictionaryValService;

    @GetMapping("/getDicByCode/{code}")
    @ApiOperation(value = "通过编码获取字典值")
    public Result<Object> getDicByCode(@PathVariable("code") String code) {

        List<DictionaryVal> dictionaryVals = dictionaryValService.getDicByCode(code);
        if (null == dictionaryVals) {
            return new ResultUtil<Object>().setErrorMsg("不存在该类型的字典");
        }
        return new ResultUtil<Object>().setData(dictionaryVals);
    }
}
