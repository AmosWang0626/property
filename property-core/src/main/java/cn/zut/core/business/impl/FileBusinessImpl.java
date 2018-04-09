package cn.zut.core.business.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.FileBusiness;
import cn.zut.core.config.PropertyConfig;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * PROJECT: property
 * DATE: 2017/12/25
 *
 * @author DaoYuanWang
 */
@Component
public class FileBusinessImpl implements FileBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileBusinessImpl.class);

    @Resource
    private PropertyConfig propertyConfig;

    @Override
    public GenericResponse upload(MultipartFile partFile) {
        // 初始化图片名字以及设置自定义文件夹
        String basePathAndFileName = initBasePathAndFileName(partFile);
        // 图片访问路径
        String accessPath = propertyConfig.getServerHost() + basePathAndFileName;
        LOGGER.info("上传的文件路径及名字: [{}]", accessPath);
        // 图片真实保存路径
        String filePath = propertyConfig.getUploadPath() + basePathAndFileName;
        try {
            FileUtils.copyInputStreamToFile(partFile.getInputStream(), new File(filePath));
            // 设置图片权限
            Runtime.getRuntime().exec("chmod 644 " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GenericResponse<>(accessPath);
    }

    private String initBasePathAndFileName(MultipartFile partFile) {
        String filePath = partFile.getOriginalFilename();
        // 获取文件拓展名
        String suffix = filePath.lastIndexOf(".") <= 0 ? ".jpg" : filePath.substring(filePath.lastIndexOf("."));
        return "/img/" + System.currentTimeMillis() + suffix;
    }
}