package xyz.wcx412.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.ComputerInfo;
import xyz.wcx412.form.ComputerForm;
import xyz.wcx412.service.ComputerInfoService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 电脑详细信息表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/computer")
@Api(tags = "电脑信息接口")
public class ComputerInfoController {

    @Autowired
    private ComputerInfoService computerInfoService;

    @ApiOperation(value = "添加新的电脑")
    @PostMapping("/addComputer")
    public ResultBody addComputer(@RequestBody ComputerInfo computerInfo){
        return computerInfoService.addComputer(computerInfo);
    }

    @ApiOperation(value = "用户购买电脑")
    @PostMapping("/buyComputer")
    public ResultBody buyComputer(Long computerId, Long userId){
        return computerInfoService.buyComputer(computerId, userId);
    }

    @ApiOperation(value = "根据电脑id查找对应的电脑信息")
    @GetMapping("/findComputerById")
    public ResultBody findComputerById(Long computerId){
        return ResultBodyUtil.success(computerInfoService.getById(computerId));
    }

    @ApiOperation(value = "分页查询所有的电脑")
    @GetMapping("/findAllComputerByPage")
    public ResultBody findAllComputerByPage(Integer currentPage, Integer pageSize){
        return computerInfoService.findAllComputerByPage(currentPage, pageSize);
    }

    @ApiOperation(value = "查找所有的电脑")
    @GetMapping("/findAllComputer")
    public ResultBody findAllComputer(){
        return ResultBodyUtil.success(computerInfoService.list());
    }

    @ApiOperation(value = "查找所有电脑通过用户id")
    @GetMapping("/findComputerByUserId")
    public ResultBody findComputerByUserId(Long userId){
        return computerInfoService.findComputerByUserId(userId);
    }

    @ApiOperation(value = "分页并模糊胡查询")
    @GetMapping("/findAllComputerByPageAndFuzzy")
    public ResultBody findAllComputerByPageAndFuzzy(Integer currentPage, Integer pageSize, @RequestBody ComputerForm computerForm){
        return computerInfoService.findAllComputerByPageAndFuzzyAndStatus(currentPage, pageSize, computerForm);
    }

    @ApiOperation(value = "用户分页并模糊查询")
    @GetMapping("/findAllByUserIdAndPageAndFuzzy")
    public ResultBody findAllByUserIdAndPageAndFuzzy(Integer currentPage, Integer pageSize,
                                                     Long userId,
                                                     @RequestBody ComputerForm computerForm){
        return computerInfoService.findAllByUserIdAndPageAndFuzzy(currentPage, pageSize, userId, computerForm);
    }

    @ApiOperation(value = "更新电脑信息")
    @PostMapping("/updateComputer")
    public ResultBody updateComputer(@RequestBody ComputerInfo computerInfo){
        return ResultBodyUtil.success(computerInfoService.updateById(computerInfo));
    }

    @ApiOperation(value = "删除电脑")
    @PostMapping("/deleteComputer")
    public ResultBody deleteComputer(Long computerId){
        return ResultBodyUtil.success(computerInfoService.removeById(computerId));
    }

}
