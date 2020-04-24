package com.modules.video.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.utils.ResultUtil;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.common.vo.Result;
import com.modules.video.entity.Player;
import com.modules.video.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xiake
 * @Date: 2020/4/7 15:30
 * @Description:
 **/
@RestController
@RequestMapping("video/player")
public class PlayerController {

//    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    @Autowired
    private PlayerService playerService;

//    @Autowired
//    private QiniuUtil qiniuUtil;
//
//    @PostMapping("qiniu")
//    public Result<Object> uploadImgQiniu(@RequestParam(value = "file",required = false) MultipartFile multipartFile) throws IOException {
//        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
//        String path = qiniuUtil.uploadImg(inputStream, String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
//        return new ResultUtil<Object>().setData(path);
//    }

    @GetMapping("getAllByPage")
    public Result<IPage<Player>> getAllVideo(@ModelAttribute Player player,
                                             @ModelAttribute DateVo dateVo,
                                             @ModelAttribute PageVo pageVo){
        IPage<Player> iPage = playerService.getByCondition(pageVo,player, dateVo);
        return new ResultUtil<IPage<Player>>().setData(iPage);
    }

    @PostMapping("publish")
    public Result<Player> publish(@RequestBody Player player){
        playerService.publish(player);
        return new ResultUtil<Player>().setData(player);
    }
}
