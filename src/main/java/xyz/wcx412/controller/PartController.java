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
import xyz.wcx412.entity.Part;
import xyz.wcx412.service.PartService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 电脑零件 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/part")
@Api(tags = "零件接口")
public class PartController {

    @Autowired
    private PartService partService;

    @ApiOperation(value = "分页查找所有的零件")
    @GetMapping("/findAllPartsByPage")
    public ResultBody findAllPartsByPage(Integer currentPage, Integer pageSize){
        Page<Part> partPage = new Page<>(currentPage, pageSize);
        IPage<Part> iPage = partService.page(partPage);
        return ResultBodyUtil.success(iPage);
    }

    @ApiOperation(value = "添加零件")
    @PostMapping("/addParts")
    public ResultBody addParts(Part part){
        return partService.addParts(part);
    }

    @ApiOperation(value = "使用零件")
    @PostMapping("/usePart")
    public ResultBody usePart(Long partId){
        Part part = partService.getById(partId);
        part.setNum(part.getNum() - 1);
        partService.updateById(part);
        return ResultBodyUtil.success();
    }
}
