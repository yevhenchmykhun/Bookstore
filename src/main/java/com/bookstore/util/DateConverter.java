package com.bookstore.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public long toDateInMillis(String date, String format) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date d;
        try {
            d = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IOException("Not able to parse date", e);
        }

        return d.getTime();
    }

    public String toDateInString(long millis, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(new Date(millis));
    }

}
