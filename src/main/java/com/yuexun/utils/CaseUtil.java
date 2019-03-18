package com.yuexun.utils;

import java.util.Date;

public class CaseUtil {

        public static String idNOToAge(String idNO){
            int leh = idNO.length();
            String dates="";
            if (leh == 18) {
                dates = idNO.substring(6, 10);
            }else if(leh==15){
                dates = idNO.substring(6, 8);
            }else {
                return "";
            }
            String year= DateNewUtil.format(new Date(),"yyyy");
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return String.valueOf(u);
        }
}
