package xyz.wcx412.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Feedback;
import xyz.wcx412.service.FeedbackService;
import xyz.wcx412.utils.ResultBodyUtil;

/**
 * <p>
 * 意见反馈 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/feedback")
@Api(tags = "意见反馈接口")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "添加新的问题")
    @PostMapping("/addQuestion")
    public ResultBody addQuestion(@RequestBody Feedback feedback) {
        return feedbackService.addQuestion(feedback);
    }

    @ApiOperation(value = "回答问题")
    @PostMapping("/addAnswer")
    public ResultBody addAnswer(Long questionId, String answer) {
        return feedbackService.addAnswer(questionId, answer);
    }

    @ApiOperation(value = "不传状态为查询所有问题，0为未回答")
    @GetMapping("/findAllFeedbackByPage")
    public ResultBody findAllFeedbackByPage(Integer currentPage, Integer pageSize, Integer status){
        return feedbackService.findAllFeedbackByPage(currentPage, pageSize, status);
    }

    @ApiOperation(value = "查询所有意见反馈")
    @GetMapping("/findAllFeedback")
    public ResultBody findAllFeedback(){
        return ResultBodyUtil.success(feedbackService.list());
    }

    @ApiOperation(value = "根据id删除该条留言")
    @PostMapping("/deleteFeedbackById")
    public ResultBody deleteFeedbackById(Integer feedbackId){
        return ResultBodyUtil.success(feedbackService.removeById(feedbackId));
    }

    @ApiOperation(value = "通过用户id查询所有意见反馈")
    @GetMapping("/findAllFeedbackByUserId")
    public ResultBody findAllFeedbackByUserId(Long userId){
        return feedbackService.findAllFeedbackByUserId(userId);
    }



}
