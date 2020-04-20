/**
 * @Title: CustomException.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-20
 */
package com.how2java.tmall.exeception;

/**
 * @Name: CustomException
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-20
 */
public class CustomException extends Exception {
    // 异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}