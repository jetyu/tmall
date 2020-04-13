package com.how2java.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Name: UploadedImageFile
 * @Description: TODO(上传图片的工具类)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}