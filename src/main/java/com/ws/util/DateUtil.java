package com.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alvin on 2016/5/7.
 */
public class DateUtil {
    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static Date formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
