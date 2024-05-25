package com.yupi.yudada.service;

import com.yupi.yudada.model.entity.ApplyRecords;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author daiyifei
* @description 针对表【apply_records(申请记录表)】的数据库操作Service
* @createDate 2024-01-29 17:22:24
*/
public interface ApplyRecordsService extends IService<ApplyRecords> {

    void validApplyRecords(ApplyRecords applyRecords, boolean add);

}
