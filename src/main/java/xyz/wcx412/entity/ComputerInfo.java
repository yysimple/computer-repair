package xyz.wcx412.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import xyz.wcx412.entity.base.BaseEntity;

/**
 * <p>
 * 电脑详细信息表
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ComputerInfo对象", description="电脑详细信息表")
public class ComputerInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电脑编号")
    private String computerNo;

    @ApiModelProperty(value = "电脑品牌")
    private String brand;

    @ApiModelProperty(value = "电脑型号")
    private String model;

    @ApiModelProperty(value = "电脑价格")
    private Double price;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "电脑的图片")
    private String url;

    @ApiModelProperty(value = "电脑的状态,默认为1,1是未卖出")
    private Integer status;


}
