package xyz.wcx412.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
@ApiModel
public class ComputerForm {

    @ApiModelProperty(value = "电脑编号")
    private String computerNo;

    @ApiModelProperty(value = "电脑型号")
    private String model;

    @ApiModelProperty(value = "电脑品牌")
    private String brand;

    @ApiModelProperty(value = "电脑销售状态")
    private Integer status;

    @ApiModelProperty(value = "电脑价格区间开始值")
    private Double startPrice;

    @ApiModelProperty(value = "电脑价格区间结束值")
    private Double endPrice;
}
