package com.how2java.tmall.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Name: UploadedImageFile
 * @Description: UploadedImageFile(上传图片的工具类)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class UploadedImageFile {
    MultipartFile image;

    /**
     * 定义logger
     */
    private Logger logger = LoggerFactory.getLogger(UploadedImageFile.class);

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    /**
     * 获取文件数量
     *
     * @Title: getFileList
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param filePath
     */
    public void getFileList(String filePath) {
        try {
            int count = 0;
            File file = new File(filePath);
            // get the folder list
            File[] array = file.listFiles();
            for (File fileList : array) {
                if (fileList.isFile()) {
                    logger.info("图片文件：" + fileList.getPath());
                    ++count;
                }
            }
            logger.info("文件夹内图片数量为: " + count);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取文件数量
     *
     * @Title: getFileCount
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param filePath
     */
    public void getFileCount(String filePath) {
        try {
            int count = 0;
            for (File files : new File(filePath).listFiles()) {
                if (files.isFile()) {
                    ++count;
                }
            }
            logger.info("文件夹内图片数量为: " + count);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
