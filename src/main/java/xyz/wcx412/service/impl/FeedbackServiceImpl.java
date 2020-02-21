package xyz.wcx412.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Feedback;
import xyz.wcx412.mapper.FeedbackMapper;
import xyz.wcx412.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.List;

/**
 * <p>
 * 意见反馈 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public ResultBody addQuestion(Feedback feedback) {
        feedbackMapper.insert(feedback);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody addAnswer(Long questionId, String answer) {
        Feedback feedback = feedbackMapper.selectById(questionId);
        feedback.setAnswer(answer);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findAllFeedbackByPage(Integer currentPage, Integer pageSize, Integer status) {
        Page<Feedback> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Feedback> queryWrapper = Wrappers.query();
        if (!StrUtil.isEmptyIfStr(status)) {
            queryWrapper.eq("status", status);
        }
        IPage<Feedback> iPage = feedbackMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(iPage);
    }

    @Override
    public ResultBody findAllFeedbackByUserId(Long userId) {
        QueryWrapper<Feedback> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userId);
        List<Feedback> feedbacks = feedbackMapper.selectList(queryWrapper);
        return ResultBodyUtil.success(feedbacks);
    }
}
