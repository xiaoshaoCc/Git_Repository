package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.Appversions;
import com.example.zhangshangmeishibao.Repository.FileRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/download")
    public void download(@RequestParam String fileName, HttpServletResponse response) {
        //  新建文件流，从磁盘读取文件流
        try (FileInputStream fis = new FileInputStream("/resources/Version/" + fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream()) {    //  OutputStream 是文件写出流，讲文件下载到浏览器客户端
            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
            byte[] bytes = new byte[bis.available()];
            // 从文件流读取字节到字节数组中
            bis.read(bytes);
            // 重置 response
            response.reset();
            // 设置 response 的下载响应头
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 注意，这里要设置文件名的编码，否则中文的文件名下载后不显示
            // 写出字节数组到输出流
            os.write(bytes);
            // 刷新输出流
            os.flush();
        } catch (ClientAbortException e) {
            // 客户端中断连接，可以记录日志或进行其他处理
            System.out.println("用户断开连接");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/find")
    public String versionCheck(){
        List<Appversions> appversions = fileRepository.findAll();
        return appversions.get(0).getVersionname();

    }
}
