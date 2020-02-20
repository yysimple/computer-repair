package xyz.wcx412.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Trouble;
import xyz.wcx412.service.TroubleService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 电脑问题表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/trouble")
@Api(tags = "故障接口")
public class TroubleController {

    @Autowired
    private TroubleService troubleService;

    /**
     * 状态为0,0为禁用
     */
    public static final int STATUS_ZERO = 0;

    @ApiOperation(value = "查找所有的故障信息")
    @GetMapping("/findAllTroubleInfo")
    public ResultBody findAllTroubleInfoByPage(Integer currentPage, Integer pageSize){
        Page<Trouble> page = new Page<>(currentPage, pageSize);
        IPage<Trouble> iPage = troubleService.page(page);
        return ResultBodyUtil.success(iPage);
    }

    @ApiOperation(value = "查询所有的故障信息")
    @GetMapping("/findAllTrouble")
    public ResultBody findAllTrouble(){
        return ResultBodyUtil.success(troubleService.list());
    }


    @ApiOperation(value = "添加故障信息")
    @PostMapping("/addTroubleInfo")
    public ResultBody addTroubleInfo(Trouble trouble){
        return troubleService.addTrouble(trouble);
    }

    @ApiOperation(value = "改变状态，0为禁用，传当前状态值即可")
    @PostMapping("/changeStatus")
    public ResultBody changeStatus(Integer status){
        Trouble trouble = new Trouble();
        if (STATUS_ZERO == status) {
            trouble.setStatus(1);
            return ResultBodyUtil.success(troubleService.updateById(trouble));
        }
        trouble.setStatus(0);
        return ResultBodyUtil.success(troubleService.updateById(trouble));
    }

    @ApiOperation(value = "删除该故障信息")
    @PostMapping("/deleteTroubleById")
    public ResultBody deleteTroubleById(Long troubleId){
        return ResultBodyUtil.success(troubleService.removeById(troubleId));
    }


}
