package xyz.wcx412.service;

import cn.hutool.core.util.StrUtil;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 意见反馈 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 功能描述: 提问
     *
     * @param feedback
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addQuestion(Feedback feedback);

    /**
     * 功能描述: 回答问题
     *
     * @param questionId
     * @param answer
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addAnswer(Long questionId, String answer);

    /**
     * 功能描述: 查询所有的意见反馈
     *
     * @param status
     * @param currentPage
     * @param pageSize
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllFeedbackByPage(Integer currentPage, Integer pageSize, Integer status);
}
