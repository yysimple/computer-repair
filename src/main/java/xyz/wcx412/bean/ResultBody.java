package xyz.wcx412.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：返回实体类
 *
 * @author wcx
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody {

    /**
     * 返回状态
     */
    private Integer status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

}
