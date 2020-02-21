package xyz.wcx412.mapper;

import org.springframework.stereotype.Repository;
import xyz.wcx412.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 功能描述: 通过用户名查找用户
     *
     * @Author wcx
     * @param username
     * @return xyz.wcx412.entity.User
     **/
    User findUserByUsername(String username);
}
