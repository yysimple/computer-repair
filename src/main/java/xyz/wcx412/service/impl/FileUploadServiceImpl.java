package xyz.wcx412.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.wcx412.service.FileUploadService;
import xyz.wcx412.utils.AliyunOss;
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
        if (file == null || file.getSize() <= 0) {
            throw new RuntimeException("file不能为空");
        }
        AliyunOss ossClient = new AliyunOss();
        String name = null;
        try {
            name = ossClient.uploadImg2Oss(file, "personalInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = ossClient.getImgUrl(name, "personalInfo");
        String[] split = imgUrl.split("\\?");
        return split[0];
    }

    @Override
    public String feedbackImages(MultipartFile file) {
        if (file == null || file.getSize() <= 0) {
            throw new RuntimeException("file不能为空");
        }
        AliyunOss ossClient = new AliyunOss();
        String name = null;
        try {
            name = ossClient.uploadImg2Oss(file, "feedback");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = ossClient.getImgUrl(name, "feedback");
        String[] split = imgUrl.split("\\?");
        return split[0];
    }

    @Override
    public String computerImages(MultipartFile file) {
        if (file == null || file.getSize() <= 0) {
            throw new RuntimeException("file不能为空");
        }
        AliyunOss ossClient = new AliyunOss();
        String name = null;
        try {
            name = ossClient.uploadImg2Oss(file, "computerInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = ossClient.getImgUrl(name, "computerInfo");
        String[] split = imgUrl.split("\\?");
        return split[0];
    }

    @Override
    public String partImages(MultipartFile file) {
        if (file == null || file.getSize() <= 0) {
            throw new RuntimeException("file不能为空");
        }
        AliyunOss ossClient = new AliyunOss();
        String name = null;
        try {
            name = ossClient.uploadImg2Oss(file, "part");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = ossClient.getImgUrl(name, "part");
        String[] split = imgUrl.split("\\?");
        return split[0];
    }
}
