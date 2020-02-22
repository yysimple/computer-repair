package xyz.wcx412.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.ComputerInfo;
import xyz.wcx412.enums.ResultTypeEnum;
import xyz.wcx412.form.ComputerForm;
import xyz.wcx412.mapper.ComputerInfoMapper;
import xyz.wcx412.service.ComputerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.List;

/**
 * <p>
 * 电脑详细信息表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class ComputerInfoServiceImpl extends ServiceImpl<ComputerInfoMapper, ComputerInfo> implements ComputerInfoService {

    @Autowired
    private ComputerInfoMapper computerInfoMapper;

    @Override
    public ResultBody addComputer(ComputerInfo computerInfo) {
        List<ComputerInfo> computerInfos = computerInfoMapper.selectList(null);
        boolean b = computerInfos.stream()
                .anyMatch(computerInfo1 -> computerInfo1.getComputerNo().equals(computerInfo.getComputerNo()));
        if (b) {
            return ResultBodyUtil.error(ResultTypeEnum.COMPUTER_NO_EXIST.getCode(),
                    ResultTypeEnum.COMPUTER_NO_EXIST.getMsg());
        }
        computerInfoMapper.insert(computerInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody buyComputer(Long computerId, Long userId) {
        ComputerInfo computerInfo = computerInfoMapper.selectById(computerId);
        computerInfo.setUserId(userId);
        computerInfo.setStatus(0);
        computerInfoMapper.updateById(computerInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findAllComputerByPage(Integer currentPage, Integer pageSize) {
        Page<ComputerInfo> page = new Page<>(currentPage, pageSize);
        QueryWrapper<ComputerInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("status", 1);
        IPage iPage = computerInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(iPage);
    }

    @Override
    public ResultBody findAllComputerByPageAndFuzzyAndStatus(Integer currentPage, Integer pageSize, ComputerForm computerForm) {
        Page<ComputerInfo> page = new Page<>(currentPage, pageSize);
        QueryWrapper<ComputerInfo> queryWrapper = Wrappers.query();
        if (!StrUtil.hasBlank(computerForm.getComputerNo())) {
            queryWrapper.eq("computer_no", computerForm.getComputerNo());
        }
        if (!StrUtil.hasBlank(computerForm.getBrand())) {
            queryWrapper.like("brand", computerForm.getBrand());
        }
        if (!StrUtil.hasBlank(computerForm.getModel())) {
            queryWrapper.like("model", computerForm.getModel());
        }
        if (!StrUtil.isEmptyIfStr(computerForm.getStartPrice())
        && !StrUtil.isEmptyIfStr(computerForm.getEndPrice())){
            queryWrapper.between("price", computerForm.getStartPrice(), computerForm.getEndPrice());
        }
        if (!StrUtil.isEmptyIfStr(computerForm.getStatus())){
            queryWrapper.eq("status", computerForm.getStatus());
        }
        IPage<ComputerInfo> iPage = computerInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(iPage);
    }

    @Override
    public ResultBody findAllByUserIdAndPageAndFuzzy(Integer currentPage, Integer pageSize, Long userId, ComputerForm computerForm) {
        Page<ComputerInfo> page = new Page<>(currentPage, pageSize);
        QueryWrapper<ComputerInfo> queryWrapper = Wrappers.query();
        if (!StrUtil.isEmptyIfStr(userId)) {
            queryWrapper.eq("user_id", userId);
        }
        if (!StrUtil.hasBlank(computerForm.getComputerNo())) {
            queryWrapper.eq("computer_no", computerForm.getComputerNo());
        }
        if (!StrUtil.hasBlank(computerForm.getBrand())) {
            queryWrapper.like("brand", computerForm.getBrand());
        }
        if (!StrUtil.hasBlank(computerForm.getModel())) {
            queryWrapper.like("model", computerForm.getModel());
        }
        if (!StrUtil.isEmptyIfStr(computerForm.getStartPrice())
                && !StrUtil.isEmptyIfStr(computerForm.getEndPrice())){
            queryWrapper.between("price", computerForm.getStartPrice(), computerForm.getEndPrice());
        }
        IPage<ComputerInfo> iPage = computerInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(iPage);
    }

    @Override
    public ResultBody findComputerByUserId(Long userId) {
        QueryWrapper<ComputerInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id" ,userId);
        List<ComputerInfo> computerInfos = computerInfoMapper.selectList(queryWrapper);
        return ResultBodyUtil.success(computerInfos);
    }
}
