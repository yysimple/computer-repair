package xyz.wcx412.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Trouble;
import xyz.wcx412.enums.ResultTypeEnum;
import xyz.wcx412.mapper.TroubleMapper;
import xyz.wcx412.service.TroubleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.List;

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

    @Autowired
    private TroubleMapper troubleMapper;

    @Override
    public ResultBody addTrouble(Trouble trouble) {
        List<Trouble> troubles = troubleMapper.selectList(null);
        boolean b = troubles.stream()
                .anyMatch(trouble1 -> trouble1.getTroubleName().equals(trouble.getTroubleName()));
        if (b) {
            return ResultBodyUtil.error(ResultTypeEnum.TROUBLE_ALREADY_EXIST.getCode(),
                    ResultTypeEnum.TROUBLE_ALREADY_EXIST.getMsg());
        }
        troubleMapper.insert(trouble);
        return ResultBodyUtil.success();
    }
}
