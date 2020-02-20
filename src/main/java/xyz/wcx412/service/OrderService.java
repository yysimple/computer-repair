package xyz.wcx412.service;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.wcx412.form.OrderForm;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface OrderService extends IService<Order> {

    /**
     * 功能描述: 分页且模糊查找所有订单
     *
     * @param orderForm
     * @param currentPage
     * @param pageSize
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllOrderByPageAndFuzzy(Integer currentPage, Integer pageSize, OrderForm orderForm);

}
