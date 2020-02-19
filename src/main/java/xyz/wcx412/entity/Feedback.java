package xyz.wcx412.entity;

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
 * 意见反馈
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Feedback对象", description="意见反馈")
public class Feedback extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "反馈的用户id")
    private Long userId;

    @ApiModelProperty(value = "问题内容")
    private String question;

    @ApiModelProperty(value = "回答的内容")
    private String answer;



}
