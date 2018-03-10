package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.FileBusiness;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件处理处理相关
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@RequestMapping("file")
@Controller
public class FileController {

    @Resource
    private FileBusiness fileBusiness;

    /**
     * 上传图片
     *
     * @param partFile 图片
     * @return 通用
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public GenericResponse upload(final @RequestParam("partFile") MultipartFile partFile) {
        return fileBusiness.upload(partFile);
    }
}
