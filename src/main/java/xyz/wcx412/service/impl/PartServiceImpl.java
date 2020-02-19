package xyz.wcx412.service.impl;

import xyz.wcx412.entity.Part;
import xyz.wcx412.mapper.PartMapper;
import xyz.wcx412.service.PartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电脑零件 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class PartServiceImpl extends ServiceImpl<PartMapper, Part> implements PartService {

}
