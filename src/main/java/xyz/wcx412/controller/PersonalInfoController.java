package xyz.wcx412.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.PersonalInfo;
import xyz.wcx412.service.PersonalInfoService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 个人详细信息 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/personal")
@Api(tags = "个人信息接口")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @ApiOperation(value = "修改个人信息")
    @PostMapping("/updatePersonalInfo")
    public ResultBody updatePersonalInfo(PersonalInfo personalInfo){
        personalInfoService.updateById(personalInfo);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "展示个人信息")
    @GetMapping("/findPersonalInfoByUserId")
    public ResultBody findPersonalInfoByUserId(Long userId){
        QueryWrapper<PersonalInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userId);
        PersonalInfo personalInfo = personalInfoService.getOne(queryWrapper);
        return ResultBodyUtil.success(personalInfo);
    }

}
