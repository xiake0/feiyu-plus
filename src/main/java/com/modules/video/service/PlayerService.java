package com.modules.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.modules.video.entity.Player;

/**
 * @Author: xiake
 * @Date: 2020/4/7 15:22
 * @Description:
 **/
public interface PlayerService extends IService<Player> {

    IPage<Player> getByCondition(PageVo pageVo, Player player, DateVo dateVo);

    void publish(Player player);
}
