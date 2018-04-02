package cn.zut.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * PROJECT: property
 * DESCRIPTION: 配置文件
 *
 * @author DaoYuanWang
 * @date 2018/4/2
 */
@Configuration
@Data
public class PropertyConfig {

    /**
     * 上传文件路径
     */
    @Value("${uploadPath}")
    private String uploadPath;
    /**
     * 当前环境(DEV开发/TEST测试/PRO生产)
     */
    @Value("${env}")
    private String env;

}
