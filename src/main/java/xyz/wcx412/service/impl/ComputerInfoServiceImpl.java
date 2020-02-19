package xyz.wcx412.service.impl;

import xyz.wcx412.entity.ComputerInfo;
import xyz.wcx412.mapper.ComputerInfoMapper;
import xyz.wcx412.service.ComputerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电脑详细信息表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class ComputerInfoServiceImpl extends ServiceImpl<ComputerInfoMapper, ComputerInfo> implements ComputerInfoService {

}
