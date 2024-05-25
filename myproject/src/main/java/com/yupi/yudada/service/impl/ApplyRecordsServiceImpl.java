package com.yupi.yudada.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yudada.common.ErrorCode;
import com.yupi.yudada.exception.BusinessException;
import com.yupi.yudada.exception.ThrowUtils;
import com.yupi.yudada.model.entity.ApplyRecords;
import com.yupi.yudada.service.ApplyRecordsService;
import com.yupi.yudada.mapper.ApplyRecordsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author daiyifei
* @description 针对表【apply_records(申请记录表)】的数据库操作Service实现
* @createDate 2024-01-29 17:22:24
*/
@Service
public class ApplyRecordsServiceImpl extends ServiceImpl<ApplyRecordsMapper, ApplyRecords>
    implements ApplyRecordsService{

    @Override
    public void validApplyRecords(ApplyRecords applyRecords, boolean add) {
        if (applyRecords == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String content = applyRecords.getContent();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(content), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(content) && content.length() > 4096) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "申请内容过长");
        }
    }
}




