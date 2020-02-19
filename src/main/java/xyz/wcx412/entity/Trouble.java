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

/**
 * <p>
 * 电脑问题表
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Trouble对象", description="电脑问题表")
public class Trouble implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "问题编号")
    private String troubleNo;

    @ApiModelProperty(value = "问题名称")
    private String troubleName;

    @ApiModelProperty(value = "问题备注")
    private String remark;

    @ApiModelProperty(value = "问题的状态，电脑的问题是否可以维修，0表示不可以，1表示可以")
    private Integer status;


}
