package xyz.wcx412.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.mapper.VisitorMapper;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 访问记录表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/visitor")
@Api(tags = "访客接口")
public class VisitorController {

    @Autowired
    private VisitorMapper visitorMapper;

    @ApiOperation(value = "查询所有访问记录")
    @GetMapping("/findAllVisitor")
    public ResultBody findAllVisitor(){
        return ResultBodyUtil.success(visitorMapper.selectList(null));
    }
}
