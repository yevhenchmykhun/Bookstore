package com.yevhenchmykhun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public long toDateInMillis(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = dateFormat.parse(date);
        } catch (ParseException e) {
            //NOOP
        }

        return d.getTime();
    }

    public String toDateInString(long millis, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String date = dateFormat.format(new Date(millis));

        return date;
    }

}
