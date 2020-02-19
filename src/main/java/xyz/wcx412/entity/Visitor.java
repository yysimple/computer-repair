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
 * 访问记录表
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Visitor对象", description="访问记录表")
public class Visitor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应的用户id")
    private Long userId;

    @ApiModelProperty(value = "对应的用户名")
    private String username;

}
