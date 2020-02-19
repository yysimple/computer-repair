package xyz.wcx412.utils;

import xyz.wcx412.bean.ResultBody;

/**
 * 功能描述：返回工具类
 *
 * @author wcx
 * @version 1.0
 */
public final class ResultBodyUtil {

    /**
     * 功能描述: 请求成功的返回值，且有数据返回
     *
     * @param object
     * @return cn.jxwxkj.res.ResultBody
     * @Author wcx
     **/
    public static ResultBody success(Object object) {
        ResultBody resultBody = new ResultBody();
        resultBody.setStatus(200);
        resultBody.setMsg("成功");
        resultBody.setData(object);
        return resultBody;
    }

    /**
     * 功能描述: 请求成功的返回值，且没有数据返回
     *
     * @param
     * @return cn.jxwxkj.res.ResultBody
     * @Author wcx
     **/
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 功能描述: 返回失败情况
     *
     * @param status
     * @param msg
     * @return cn.jxwxkj.res.ResultBody
     * @Author wcx
     **/
    public static ResultBody error(Integer status, String msg) {
        ResultBody resultBody = new ResultBody();
        resultBody.setStatus(status);
        resultBody.setMsg(msg);
        return resultBody;
    }

}
