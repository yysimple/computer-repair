package xyz.wcx412.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class OrderVo {

    @ApiModelProperty(value = "对应的用户名")
    private String username;

    @ApiModelProperty(value = "对应的电脑的编号")
    private String computerNo;

    @ApiModelProperty(value = "对应的故障编号")
    private String troubleNo;

    @ApiModelProperty(value = "联系人姓名")
    private String contact;

    @ApiModelProperty(value = "联系人的电话号码")
    private String contactTel;

    @ApiModelProperty(value = "订单创建时间")
    private LocalDateTime createTime;

}
