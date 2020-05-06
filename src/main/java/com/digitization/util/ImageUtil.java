package com.digitization.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtil {

    private static final String PRE = "data:image/png;base64,";
    public static String encodeImageToBase64(String imgPath) {
        String encoderDate = encodeImageToBase64ByPath(imgPath);
        if (StringUtils.isBlank(encoderDate)) {
            return null;
        }
        return PRE+encoderDate;
    }

    public static String encodeImageToBase64ByPath(String path) {
        if (StringUtils.isBlank(path)) {
            return null;
        }
        try {
            InputStream is = new FileInputStream(new File(path));
            // 得到图片的二进制数据，以二进制封装得到数据
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            // 每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            // 使用一个输入流从buffer里把数据读取出来
            while ((len = is.read(buffer)) != -1) {
                // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                os.write(buffer, 0, len);
            }
            // 关闭输入流
            is.close();
            byte[] data = os.toByteArray();
            // 对字节数组Base64编码
            return Base64.encodeBase64String(data);
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(encodeImageToBase64("C:/Users/Administrator/Desktop/matlab/img.jpg"));
    }
}