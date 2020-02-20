package xyz.wcx412.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public interface FileUploadService {

    /**
     * 功能描述: 上传头像
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    String personalHeaderImages(MultipartFile file);

    /**
     * 功能描述: 意见反馈图片
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    String feedbackImages(MultipartFile file);

    /**
     * 功能描述: 电脑图片
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    String computerImages(MultipartFile file);

    /**
     * 功能描述: 零件图片
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    String partImages(MultipartFile file);

}
