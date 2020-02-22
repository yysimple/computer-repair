package xyz.wcx412.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.OrderInfo;
import xyz.wcx412.form.OrderForm;
import xyz.wcx412.mapper.OrderMapper;
import xyz.wcx412.service.OrderService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 状态为0, 0为未处理
     */
    public static final int STATUS_ZERO = 0;

    @ApiOperation(value = "查询所有订单")
    @GetMapping("/findAllOrderByPageAndFuzzy")
    public ResultBody findAllOrderByPageAndFuzzy(Integer currentPage, Integer pageSize, @RequestBody OrderForm orderForm){
        return orderService.findAllOrderByPageAndFuzzy(currentPage, pageSize, orderForm);
    }

    @ApiOperation(value = "改变订单状态,0为未处理")
    @PostMapping("/changeStatus")
    public ResultBody changeStatus(Long orderId, Integer status){
        OrderInfo orderInfo = orderMapper.selectById(orderId);
        if (STATUS_ZERO == status) {
            orderInfo.setStatus(1);
            orderService.updateById(orderInfo);
            return ResultBodyUtil.success();
        }
        orderInfo.setStatus(0);
        orderService.updateById(orderInfo);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "删除订单信息")
    @PostMapping("/deleteOrderById")
    public ResultBody deleteOrderById(Long orderId){
        return ResultBodyUtil.success(orderService.removeById(orderId));
    }

    @ApiOperation(value = "修改订单信息")
    @PostMapping("/updateOrder")
    public ResultBody updateOrder(@RequestBody OrderInfo orderInfo){
        return ResultBodyUtil.success(orderService.updateById(orderInfo));
    }

    @ApiOperation(value = "创建新的订单")
    @PostMapping("/addOrder")
    public ResultBody addOrder(@RequestBody OrderInfo orderInfo){
        return ResultBodyUtil.success(orderService.save(orderInfo));
    }

    @ApiOperation(value = "查询所有订单")
    @GetMapping("/findAllOrder")
    public ResultBody findAllOrder(){
        return ResultBodyUtil.success(orderService.list());
    }
}
