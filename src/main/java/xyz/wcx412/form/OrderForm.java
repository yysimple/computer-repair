package xyz.wcx412.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
@ApiModel
public class OrderForm {

    @ApiModelProperty(value = "订单的状态，0为未处理")
    private Integer status;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

}
