package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author liulei
 * @date 2020-06-23-16:06
 */
public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl = "http://192.168.17.130";
        //上传图片的服务器
        //获得配置文件的路径
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(tracker);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageClient storageClient = new StorageClient(trackerServer, null);
        try {
            byte[] bytes = multipartFile.getBytes();   //活得上传文件的二进制对象
            String originalFilename = multipartFile.getOriginalFilename();  //a.jpg 原文件名
            int dx = originalFilename.lastIndexOf(".");   //获得最后一个点的位置
            String extName = originalFilename.substring(dx + 1);      //截取最后一个点之后的位置
            String[] upload_file = storageClient.upload_file(bytes, extName, null);
            for (int i = 0; i < upload_file.length; i++) {
                imgUrl += "/" + upload_file[i];
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
