package xyz.wcx412.service;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.ComputerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.wcx412.form.ComputerForm;

import java.util.List;

/**
 * <p>
 * 电脑详细信息表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface ComputerInfoService extends IService<ComputerInfo> {

    /**
     * 功能描述: 添加新电脑
     *
     * @param computerInfo
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addComputer(ComputerInfo computerInfo);

    /**
     * 功能描述: 用户购买电脑
     *
     * @param computerId
     * @param userId
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody buyComputer(Long computerId, Long userId);

    /**
     * 功能描述: 分页查找所有的电脑
     *
     * @param currentPage
     * @param pageSize
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllComputerByPage(Integer currentPage, Integer pageSize);

    /**
     * 功能描述: 条件查询所有的电脑
     *
     * @param currentPage
     * @param pageSize
     * @param computerForm
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllComputerByPageAndFuzzyAndStatus(Integer currentPage, Integer pageSize, ComputerForm computerForm);

    /**
     * 功能描述: 模糊查询对应用户的所有电脑
     *
     * @param currentPage
     * @param pageSize
     * @param userId
     * @param computerForm
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllByUserIdAndPageAndFuzzy(Integer currentPage, Integer pageSize,
                                              Long userId,
                                              ComputerForm computerForm);


}
