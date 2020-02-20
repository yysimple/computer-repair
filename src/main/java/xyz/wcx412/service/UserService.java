package xyz.wcx412.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
public interface UserService extends IService<User>, UserDetailsService {

    /**
     * 功能描述: 添加一个新的用户
     *
     * @param user
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody addUser(User user);

    /**
     * 功能描述: 查找所有的用户
     *
     * @param
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllUsers();

    /**
     * 功能描述: 分页查找所有用户
     *
     * @param currentPage
     * @param pageSize
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllUsersByPage(Integer currentPage, Integer pageSize);

    /**
     * 功能描述: 通过用户名找到对应用户
     *
     * @param username
     * @return xyz.wcx412.entity.User
     * @Author wcx
     **/
    User findUserByUserName(String username);

    /**
     * 功能描述: 根据状态查找所有的用户
     *
     * @param status
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllUsersByStatus(Integer status);

    /**
     * 功能描述: 根据类型查找所有的用户
     *
     * @param type
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody findAllUsersByType(Integer type);

    /**
     * 功能描述: 修改密码
     *
     * @param id
     * @param oldPwd
     * @param newPwd
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody changePwd(Long id, String oldPwd, String newPwd);

    /**
     * 功能描述: 修改状态
     *
     * @param id
     * @return xyz.wcx412.bean.ResultBody
     * @Author wcx
     **/
    ResultBody changeStatus(Long id);

    /**
     * 功能描述: 登录
     *
     * @param username
     * @param password
     * @return string
     * @Author wcx
     **/
    String login(String username, String password);

}
