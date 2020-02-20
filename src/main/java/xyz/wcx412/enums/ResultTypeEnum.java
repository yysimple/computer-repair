package xyz.wcx412.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 功能描述：返回失败信息封装
 *
 * @author wcx
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultTypeEnum {

    /**
     *
     */
    USER_NOT_EXIST(300, "查无此人"),
    USER_ALREADY_EXIST(301, "用户已存在"),
    USER_BE_DISABLED(302, "用户被禁用"),
    PASSWORD_NOT_TRUE(303, "密码不正确"),
    OLD_PASSWORD_FALSE(304, "旧密码不正确，请从新输入"),

    TROUBLE_ALREADY_EXIST(400, "故障名已存在，请从新输入"),

    COMPUTER_NO_EXIST(500, "电脑编号唯一，请从新输入")
    ;
    private Integer code;

    private String msg;


}
