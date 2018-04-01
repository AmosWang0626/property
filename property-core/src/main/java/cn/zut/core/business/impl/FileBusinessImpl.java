package cn.zut.core.business.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.FileBusiness;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public GenericResponse upload(MultipartFile partFile) {
        String filePath = undoFile(partFile);
        LOGGER.info("上传的文件名: ", filePath);
        try {
            FileUtils.copyInputStreamToFile(partFile.getInputStream(), new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GenericResponse.SUCCESS;
    }

    private String undoFile(MultipartFile partFile) {
        String filePath = partFile.getOriginalFilename();
        // 文件拓展名
        String suffix = filePath.lastIndexOf(".") <= 0 ? ".jpg" : filePath.substring(filePath.lastIndexOf("."));
        filePath = "/file/img/" + System.currentTimeMillis() + suffix;
        return filePath;
    }
}