package xyz.wcx412.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import xyz.wcx412.entity.base.BaseEntity;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Order对象", description="订单")
public class Order extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应的用户id")
    private Long userId;

    @ApiModelProperty(value = "对应的电脑的id")
    private Long computerId;

    @ApiModelProperty(value = "对应的问题id")
    private Long troubleId;

    @ApiModelProperty(value = "联系人姓名")
    private String contact;

    @ApiModelProperty(value = "联系人的电话号码")
    private String contactTel;

    @ApiModelProperty(value = "订单的状态，默认为0,0为未处理，1为已处理")
    private Integer status;

    @ApiModelProperty(value = "订单的备注")
    private String remark;


}
