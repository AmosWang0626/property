package cn.zut.core.business;

import cn.zut.common.generic.GenericResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * PROJECT: property
 * DATE: 2017/12/25
 *
 * @author DaoYuanWang
 */
public interface FileBusiness {

    /**
     * 上传文件
     *
     * @param partFile 文件
     * @return 通用
     */
    GenericResponse<String> upload(MultipartFile partFile);
}
