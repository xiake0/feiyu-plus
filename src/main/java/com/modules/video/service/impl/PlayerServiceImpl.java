package com.modules.video.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.modules.sys.entity.User;
import com.modules.sys.mapper.UserMapper;
import com.modules.video.entity.Player;
import com.modules.video.mapper.PlayerMapper;
import com.modules.video.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/4/7 15:23
 * @Description:
 **/
@SuppressWarnings("all")
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param pageVo
     * @param player
     * @param dateVo
     * @return
     */
    @Override
    public IPage<Player> getByCondition(PageVo pageVo, Player player, DateVo dateVo) {
        Page<Player> playerPage = new Page<>(pageVo.getPageNumber(), pageVo.getPageSize());
        IPage<Player> iPage = playerMapper.getByCondition(playerPage, player, dateVo, pageVo.getSort(), pageVo.getOrder());
        List<Player> players=iPage.getRecords();
        for(Player player1:players){
            User user=userMapper.getUserByUserId(player1.getOwnerId());
            player1.setOwnerId(user.getUsername());
        }
        return iPage;
    }

    /**
     * 发布视频
     * @param player
     */
    @Override
    public void publish(Player player) {
       playerMapper.insert(player);
    }
}
