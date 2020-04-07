package xyz.wcx412.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.User;
import xyz.wcx412.entity.Visitor;
import xyz.wcx412.enums.ResultTypeEnum;
import xyz.wcx412.mapper.UserMapper;
import xyz.wcx412.mapper.VisitorMapper;
import xyz.wcx412.service.UserService;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private VisitorMapper visitorMapper;

    private final Integer STATUS_ZERO = 0;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResultBody login(String username, String password) {
        User user = userService.findUserByUserName(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (null == user) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),
                    ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        if (STATUS_ZERO.equals(user.getStatus())) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_BE_DISABLED.getCode(),
                    ResultTypeEnum.USER_BE_DISABLED.getMsg());
        }

        if (!encoder.matches(password, user.getPassword())) {
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_TRUE.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_TRUE.getMsg());
        }
        Visitor visitor = new Visitor();
        visitor.setUserId(user.getId());
        visitor.setUsername(user.getUsername());
        visitorMapper.insert(visitor);
        String token = userService.login(username, password);
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        map.put("token", "Bearer" + token);
        return ResultBodyUtil.success(map);

    }

    @ApiOperation(value = "查找所有用户")
    @GetMapping("/findAll")
    public ResultBody findAllUsers(){
        return userService.findAllUsers();
    }

    @ApiOperation(value = "根据id查找用户")
    @GetMapping("/findUserById")
    public ResultBody findUserById(Long id){
        if (StringUtils.isEmpty(id)) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        return ResultBodyUtil.success(userMapper.selectById(id));
    }

    @ApiOperation(value = "添加一个用户, 同注册")
    @PostMapping("/save")
    public ResultBody addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "修改一个用户信息")
    @PostMapping("/updateUser")
    public ResultBody updateUser(@RequestBody User user){
        return ResultBodyUtil.success(userMapper.updateById(user));
    }

    @ApiOperation(value = "根据id删除一个用户")
    @PostMapping("/deleteById")
    public ResultBody deleteById(Long id) {
        return ResultBodyUtil.success(userMapper.deleteById(id));
    }

    @ApiOperation(value = "根据状态查找所有用户")
    @GetMapping("/findAllUsersByStatus")
    public ResultBody findAllUsersByStatus(Integer status){
        return userService.findAllUsersByStatus(status);
    }

    @ApiOperation(value = "根据类型查找所有用户")
    @GetMapping("/findAllUsersByType")
    public ResultBody findAllUsersByType(Integer type){
        return userService.findAllUsersByType(type);
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/changePwd")
    public ResultBody changePwd(Long id, String oldPwd, String newPwd){
        return userService.changePwd(id, oldPwd, newPwd);
    }

    @ApiOperation(value = "改变状态")
    @PostMapping("/changeStatus")
    public ResultBody changeStatus(Long id) {
        return userService.changeStatus(id);
    }

    @ApiOperation(value = "分页查找所有用户")
    @GetMapping("/findAllUsersByPage")
    public ResultBody findAllUsersByPage(Integer currentPage, Integer pageSize){
        return userService.findAllUsersByPage(currentPage, pageSize);
    }

}
