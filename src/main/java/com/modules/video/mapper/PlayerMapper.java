package com.modules.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.vo.DateVo;
import com.modules.video.entity.Player;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xiake
 * @Date: 2020/4/7 15:22
 * @Description:
 **/
public interface PlayerMapper extends BaseMapper<Player> {

    IPage<Player> getByCondition(Page<Player> page, @Param("p") Player player,
                                 @Param("d") DateVo dateVo, @Param("s") String sort,
                                 @Param("o") String order);

}
