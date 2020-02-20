package xyz.wcx412.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.ComputerInfo;
import xyz.wcx412.entity.Order;
import xyz.wcx412.entity.Trouble;
import xyz.wcx412.entity.User;
import xyz.wcx412.form.OrderForm;
import xyz.wcx412.mapper.OrderMapper;
import xyz.wcx412.service.ComputerInfoService;
import xyz.wcx412.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.service.TroubleService;
import xyz.wcx412.service.UserService;
import xyz.wcx412.utils.DateFormatConvertUtil;
import xyz.wcx412.utils.ResultBodyUtil;
import xyz.wcx412.vo.OrderVo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TroubleService troubleService;

    @Autowired
    private ComputerInfoService computerInfoService;

    @Override
    public ResultBody findAllOrderByPageAndFuzzy(Integer currentPage, Integer pageSize, OrderForm orderForm) {
        PageHelper.startPage(currentPage, pageSize);
        QueryWrapper<Order> queryWrapper = Wrappers.query();
        if (!StrUtil.hasBlank(orderForm.getStartTime(), orderForm.getEndTime())) {
            LocalDateTime startTime = DateFormatConvertUtil.startTime(orderForm.getStartTime());
            LocalDateTime endTime = DateFormatConvertUtil.endTime(orderForm.getEndTime());
            queryWrapper.between("create_time", startTime, endTime);
        }
        if (!StrUtil.isEmptyIfStr(orderForm.getStatus())) {
            queryWrapper.eq("status", orderForm.getStatus());
        }
        List<Order> orders = orderMapper.selectList(queryWrapper);
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order, orderVo);
            User user = userService.getById(order.getUserId());
            Trouble trouble = troubleService.getById(order.getTroubleId());
            ComputerInfo computerInfo = computerInfoService.getById(order.getComputerInfoId());
            orderVo.setComputerNo(computerInfo.getComputerNo());
            orderVo.setUsername(user.getUsername());
            orderVo.setTroubleNo(trouble.getTroubleNo());
            orderVos.add(orderVo);
        }
        PageInfo pageInfo = new PageInfo(orderVos);
        return ResultBodyUtil.success(pageInfo);
    }


}
