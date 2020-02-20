package xyz.wcx412.service;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Trouble;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 电脑问题表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface TroubleService extends IService<Trouble> {

    /**
     * 功能描述: 添加故障信息
     *
     * @param trouble
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addTrouble(Trouble trouble);
}
