package xyz.wcx412.service.impl;

import xyz.wcx412.entity.Feedback;
import xyz.wcx412.mapper.FeedbackMapper;
import xyz.wcx412.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
