package xyz.wcx412.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.PersonalInfo;
import xyz.wcx412.entity.User;
import xyz.wcx412.enums.ResultTypeEnum;
import xyz.wcx412.mapper.UserMapper;
import xyz.wcx412.service.PersonalInfoService;
import xyz.wcx412.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.utils.JwtTokenUtil;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonalInfoService personalInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 启用状态
     */
    private final Integer STATUS_NORMAL = 1;

    /**
     * 禁用状态
     */
    private final Integer STATUS_DISABLED = 0;

    private QueryWrapper<User> queryWrapper = Wrappers.query();

    @Override
    public ResultBody addUser(User user) {
        List<User> users = userMapper.selectList(null);
        boolean b = users.stream()
                .anyMatch(user1 -> user1.getUsername().equals(user.getUsername()));
        if (b) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_ALREADY_EXIST.getCode(),
            ResultTypeEnum.USER_ALREADY_EXIST.getMsg());
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insert(user);
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setUserId(user.getId());
        personalInfoService.save(personalInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findAllUsers() {
        return ResultBodyUtil.success(userMapper.selectList(null));
    }

    @Override
    public ResultBody findAllUsersByPage(Integer currentPage, Integer pageSize) {
        Page<User> page = new Page(currentPage, pageSize);
        IPage iPage = this.page(page);
        return ResultBodyUtil.success(iPage);
    }

    @Override
    public User findUserByUserName(String username) {
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public ResultBody findAllUsersByStatus(Integer status) {
        queryWrapper.eq("status", status);
        List<User> users = userMapper.selectList(queryWrapper);
        return ResultBodyUtil.success(users);
    }

    @Override
    public ResultBody findAllUsersByType(Integer type) {
        queryWrapper.eq("type", type);
        List<User> users = userMapper.selectList(queryWrapper);
        return ResultBodyUtil.success(users);
    }

    @Override
    public ResultBody changePwd(Long id, String oldPwd, String newPwd) {
        User user = userMapper.selectById(id);
        if (!user.getPassword().equals(oldPwd)) {
            return ResultBodyUtil.error(ResultTypeEnum.OLD_PASSWORD_FALSE.getCode(),
                    ResultTypeEnum.OLD_PASSWORD_FALSE.getMsg());
        }
        user.setPassword(newPwd);
        userMapper.insert(user);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody changeStatus(Long id) {
        User user = userMapper.selectById(id);
        if (user.getStatus().equals(STATUS_NORMAL)) {
            user.setStatus(STATUS_DISABLED);
            userMapper.insert(user);
            return ResultBodyUtil.success();
        }
        user.setStatus(STATUS_NORMAL);
        userMapper.insert(user);
        return ResultBodyUtil.success();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUserName(username);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }
}
