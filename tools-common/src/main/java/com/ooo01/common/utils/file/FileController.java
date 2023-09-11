package com.ooo01.common.utils.file;

import com.ooo01.common.entity.ControllerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * {@code @description:}
 */
@Slf4j
@Controller
public class FileController {
    /**
     * 通用上传请求
     *
     * @param file the file
     * @return the result
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public ControllerResult uploadFile(@RequestPart MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = "上传路径";
            // 上传并返回新文件名称
            String fileName = "";
            String url = "xxx" + fileName;
            
            
            ControllerResult controllerResult = ControllerResult.success();
            controllerResult.put("fileName", fileName);
            controllerResult.put("url", url);
            return controllerResult;
        } catch (Exception e) {
            return ControllerResult.error(e.getMessage());
        }
    }
    
    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param isDelete 是否删除
     * @param request  the request
     * @param response the response
     */
    @GetMapping("/common/download")
    public void downloadFile(String fileName, Boolean isDelete, HttpServletRequest request, HttpServletResponse response) {
        try {
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = "下载路径" + fileName;
            
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());// UTF-8
            response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);// multipart/form-data
            // response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            // FileUtils.writeBytes(filePath, response.getOutputStream());
            // if (isDelete) {
            //     FileUtils.deleteFile(filePath);
            // }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }
    
    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response) {
        // 本地资源路径
        String localPath = "";
        // 数据库资源地址
        // String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        // String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");// UTF-8
        response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);// multipart/form-data
        // response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        // FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
