package xyz.wcx412.service.impl;

import xyz.wcx412.entity.Trouble;
import xyz.wcx412.mapper.TroubleMapper;
import xyz.wcx412.service.TroubleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电脑问题表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class TroubleServiceImpl extends ServiceImpl<TroubleMapper, Trouble> implements TroubleService {

}
