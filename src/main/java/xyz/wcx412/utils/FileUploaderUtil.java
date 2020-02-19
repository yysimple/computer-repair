package xyz.wcx412.utils;

import io.minio.MinioClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * 功能描述：Minio 官方文档案例 ：https://docs.min.io/cn/java-client-quickstart-guide.html
 *
 * 项目配置地址：192.168.100.8:9000 minioadmin:minioadmin
 *
 * @author weilai
 * @version 1.0
 */
public final class FileUploaderUtil {

    public static String fileUpload(MultipartFile file, String dir) {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            //连接
            MinioClient minioClient = new MinioClient("http://192.168.109.132:9000", "wcx", "970412@wcx.com");
            //是否存在名为“test”的bucket
            if (!minioClient.bucketExists("computer")) {
                minioClient.makeBucket("computer");
            }
            String fileName = file.getOriginalFilename();
            String newName = dir + "/" + UUID.randomUUID().toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));
            //新的名称，pic会是bucket下的文件夹
            //获取file的inputStream
            InputStream inputStream = file.getInputStream();
            // 上传
            minioClient.putObject("computer", newName, inputStream, "application/octet-stream");
            inputStream.close();
            //文件访问路径
            String url = minioClient.getObjectUrl("computer", newName);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
