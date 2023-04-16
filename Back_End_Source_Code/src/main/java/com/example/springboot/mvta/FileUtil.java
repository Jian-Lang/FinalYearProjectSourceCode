package com.example.springboot.mvta;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @Author anding
 * @Param
 * @return
 * @Description
 **/
@Component
public class FileUtil {
    /**
     * oss平台域名
     */
    private static String endpoint;

    /**
     * 账号
     */
    private static String accessKeyId;

    /**
     * 秘钥
     */
    private static String accessKeySecret;

    /**
     * 存储空间名称
     */
    private static String bucketName;

    /**
     * [简要描述]:将内容写入到指定目录文件中
     *
     * @param filePath
     * @param str
     * @author hjchen
     */
    public static void writeToFileByStr(String filePath, String str) {
        FileWriter fw = null;
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file);
            fw.write(str);
        } catch (IOException e) {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e1) {
                    System.out.println(e1);
                }
            }
            System.out.println(e);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public static String uploadPicture(MultipartFile file, String filePath) {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        StringBuffer buffer = new StringBuffer();
        String fileName = renameToUUID(file.getOriginalFilename());
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            buffer.append(filePath + fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "false";
        }
        return buffer.toString();
    }

    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    /**
     * OSS文件上传
     *
     * @param multipartFile
     * @param prefixPath:   指定存储空间下的文件夹
     * @return 返回文件在OSS的唯一路径
     */
    public static String fileUpload(MultipartFile multipartFile, String prefixPath) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 新建存储空间默认为标准存储类型，私有权限。
        if (!ossClient.doesBucketExist(bucketName)) {
            ossClient.createBucket(bucketName);
        }
        long currentTimeMillis = System.currentTimeMillis();

        //文件名+毫秒值   防止文件重名被覆盖
        String type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."));
        String name = prefixPath+currentTimeMillis+UUID.randomUUID() + type;

        ByteArrayInputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ossClient.putObject(bucketName, name, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();

        String url = "https://" + bucketName + "." + endpoint + "/" + name;
        return url;
    }

    @Value("${ali.oss.endpoint}")
    public void setEndpoint(String endpoint) {
        FileUtil.endpoint = endpoint;
    }

    @Value("${ali.oss.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        FileUtil.accessKeyId = accessKeyId;
    }


    @Value("${ali.oss.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        FileUtil.accessKeySecret = accessKeySecret;
    }


    @Value("${ali.oss.bucketName}")
    public void setBucketName(String bucketName) {
        FileUtil.bucketName = bucketName;
    }

}
