package xyz.wcx412.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.wcx412.service.FileUploadService;
import xyz.wcx412.utils.FileUploaderUtil;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {


    @Override
    public String personalHeaderImages(MultipartFile file) {
        return FileUploaderUtil.fileUpload(file, "personalInfo");
    }

    @Override
    public String feedbackImages(MultipartFile file) {
        return FileUploaderUtil.fileUpload(file, "feedback");
    }

    @Override
    public String computerImages(MultipartFile file) {
        return FileUploaderUtil.fileUpload(file, "computerInfo");
    }

    @Override
    public String partImages(MultipartFile file) {
        return FileUploaderUtil.fileUpload(file, "part");
    }
}
