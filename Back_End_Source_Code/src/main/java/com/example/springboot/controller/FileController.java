package com.example.springboot.controller;

import com.example.springboot.common.res.ResultData;
import com.example.springboot.mvta.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author anding
 * @Description:
 */
@Slf4j
@Api(tags = {"文件上传"})
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${ali.oss.imagePathPrefix}")
    private String imagePathPrefix;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public ResultData fileUpload(@RequestParam("file") MultipartFile file) {
        ResultData rc = new ResultData();
        try {
            String url = FileUtil.fileUpload(file, imagePathPrefix + UUID.randomUUID() +"/");
            rc.setData(url);
        } catch (Exception e) {
            e.printStackTrace();
            rc.setErrorMsg(e.getMessage());
        }
        return rc;
    }
}
