package com.yuexun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chou on 2018/10/24.
 */
public class IdCardUtil {

    public static String convertIdCard(String idCard){
        if(idCard!=null){
            return idCard.toUpperCase();
        }
        return null;
    }

    public static Integer idNOToAge(String IdNO) {//根据身份证号算年龄
        try {
            int leh = IdNO.length();
            String dates = "";
            if (leh == 18) {
                dates = IdNO.substring(6, 10);
                SimpleDateFormat df = new SimpleDateFormat("yyyy");
                String year = df.format(new Date());
                int u = Integer.parseInt(year) - Integer.parseInt(dates);
                return u;
            } else {
                dates = IdNO.substring(6, 8);
                return Integer.parseInt(dates);
            }
        }catch (Exception e){

        }
        return null;
    }

    /**
     * 根据身份证号获取性别
     * @param idCardNo
     * @return
     */
    public static Integer getSexByIdCardNo(String idCardNo) {
        Integer sex = null;
        String sexStr = "";
        try {
            if (idCardNo.length() != 15 && idCardNo.length() != 18) {
                return null;
            }
            if (idCardNo.length() == 18) {
                sexStr = idCardNo.substring(16, 17);
            }
            if (idCardNo.length() == 15) {
                sexStr = idCardNo.substring(14, 15);
            }
            int iSex = Integer.parseInt(sexStr);
            iSex %= 2;
            if (iSex == 0) {
                sex = new Integer(2);
            } else {
                sex = new Integer(1);
            }
        } catch (Exception e) {
        }
        return sex;
    }
}
