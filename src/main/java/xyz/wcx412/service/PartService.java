package xyz.wcx412.service;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Part;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 电脑零件 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface PartService extends IService<Part> {

    /**
     * 功能描述: 添加新的零件
     *
     * @param part
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addParts(Part part);
}
