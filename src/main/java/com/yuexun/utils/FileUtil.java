package com.yuexun.utils;

/**
 * Created by Timan on 2017/6/13.
 */
public class FileUtil {

    public static String getFileSizeString(Long fileSize){
        String result = "";
        Double size = Double.valueOf(fileSize);
        if(size < 1024.0){
            result = String.format("%.2f", size) + "B";
        }else{
            size /= 1024.0;
            if(size < 1024.0){
                result = String.format("%.2f", size) + "KB";
            }else{
                size /= 1024.0;
                if(size < 1024.0){
                    result = String.format("%.2f", size) + "MB";
                }else {
                    size /= 1024.0;
                    result = String.format("%.2f", size) + "GB";

                }
            }
        }

        return result;
    }

}
