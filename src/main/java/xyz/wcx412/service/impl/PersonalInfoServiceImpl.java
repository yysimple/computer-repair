package xyz.wcx412.service.impl;

import xyz.wcx412.entity.PersonalInfo;
import xyz.wcx412.mapper.PersonalInfoMapper;
import xyz.wcx412.service.PersonalInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人详细信息 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-01-30
 */
@Service
public class PersonalInfoServiceImpl extends ServiceImpl<PersonalInfoMapper, PersonalInfo> implements PersonalInfoService {

}
