package xyz.wcx412.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.wcx412.service.FileUploadService;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController
@RequestMapping("/file")
@Api(value = "FileUploadController", tags = "文件上传接口")
public class FileUploadController {

    private FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @ApiOperation(value = "电脑图片上传")
    @PostMapping("/computerFileUpload")
    public String computerFileUpload(MultipartFile file){
        return fileUploadService.computerImages(file);
    }

    @ApiOperation(value = "零件图片上传")
    @PostMapping("/partFileUpload")
    public String batteryFileUpload(MultipartFile file){
        return fileUploadService.partImages(file);
    }

    @ApiOperation(value = "意见反馈图片上传")
    @PostMapping("/feedBackFilesUpload")
    public String feedBackFileUpload(MultipartFile file){
        return fileUploadService.feedbackImages(file);
    }

    @ApiOperation(value = "用户头像上传")
    @PostMapping("/personalHeaderFileUpload")
    public String personalHeaderFileUpload(MultipartFile file){
        return fileUploadService.personalHeaderImages(file);
    }
}
