package com.yupi.yudada.manager;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.yupi.yudada.config.TencentCosConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * 操作 Tencent Cos 对象存储
 *
 * @author yupi
 */
@Component
public class TencentCosManager {

    @Resource
    private TencentCosConfig tencentCosConfig;

    @Resource
    private COSClient cosClient;

    public PutObjectResult putObject(String key, String localFilePath) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(tencentCosConfig.getBucket(), key,
                new File(localFilePath));
        return cosClient.putObject(putObjectRequest);
    }

    public PutObjectResult putObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(tencentCosConfig.getBucket(), key,
                file);
        return cosClient.putObject(putObjectRequest);
    }


}
