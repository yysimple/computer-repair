package xyz.wcx412.mapper;

import org.springframework.stereotype.Repository;
import xyz.wcx412.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Repository
public interface OrderMapper extends BaseMapper<OrderInfo> {

}
