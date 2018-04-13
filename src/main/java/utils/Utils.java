package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * Get the current time in the specified format
     *
     * @param format date and time format e.g.: yyyy-MM-dd_HH-mm-ss
     * @return formatted time string
     */
    public static String getCurrentTime(String format) {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(dateNow);
    }
}
