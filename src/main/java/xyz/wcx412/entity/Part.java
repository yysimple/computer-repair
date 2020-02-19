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
 * 电脑零件
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Part对象", description="电脑零件")
public class Part extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "零件名称")
    private String partName;

    @ApiModelProperty(value = "零件价格")
    private Double price;

    @ApiModelProperty(value = "零件的数量")
    private Integer num;

    @ApiModelProperty(value = "零件图片，多张图片以，分开")
    private String url;


}
