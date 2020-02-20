package xyz.wcx412.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.wcx412.bean.ResultBody;
import xyz.wcx412.entity.Part;
import xyz.wcx412.mapper.PartMapper;
import xyz.wcx412.service.PartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.wcx412.utils.ResultBodyUtil;

import java.util.List;

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

    @Autowired
    private PartMapper partMapper;

    @Override
    public ResultBody addParts(Part part) {
        List<Part> parts = partMapper.selectList(null);
        for (Part part1 : parts) {
            if (part1.getPartName().equals(part.getPartName())) {
                part1.setNum(part1.getNum() + part.getNum());
                return ResultBodyUtil.success();
            }
        }
        partMapper.insert(part);
        return ResultBodyUtil.success();
    }
}
