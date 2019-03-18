package com.yuexun.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 提供 日期时间信息的相关处理
 *
 * @author Wanghk
 */
public class DateNewUtil extends DateUtils {
    private static Calendar calendar = Calendar.getInstance();
    private static final Locale locale = Locale.CHINA;
    private static final TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");

    /**
     * 用当前日期时间构造
     */
    public DateNewUtil() {
    }

    /**
     * 用一个Date对象构造
     *
     * @param date
     *            表示日期时间的Date对象
     */
    public DateNewUtil(Date date) {
        this();
        calendar.clear();
        calendar.setTime(date);
    }

    /**
     * 使用一个日期字符串构造
     *
     * @param date
     *            yyyy-MM-dd
     */
    public DateNewUtil(String date) {
        this();
        String[] temp = date.split("-");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        calendar.clear();
        calendar.set(year, month - 1, day);
    }

    /**
     * 使用一个日期时间字符串构造
     *
     * @param date
     *            yyyy-MM-dd
     * @param time
     *            HH:mm:ss
     */
    public DateNewUtil(String date, String time) {
        this();
        String[] temp = date.split("-");
        String[] temp2 = time.split(":");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        int hour = Integer.parseInt(temp2[0]);
        int minute = Integer.parseInt(temp2[1]);
        int second = Integer.parseInt(temp2[2]);
        calendar.clear();
        calendar.set(year, month - 1, day, hour, minute, second);
    }

    /**
     * 格式化日期或时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.format(date,&quot;yyyy-MM-dd&quot;) == &quot;2008-12-11&quot;;
     * DateUtil.format(date,&quot;yyyy-MM-dd HH:mm:ss&quot;) == &quot;2008-12-11 12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param f
     *            日期或时间格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String f) {
        if (date == null || StringUtils.isEmpty(f)) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(f);
        return df.format(date);
    }

    /**
     * 格式化时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.formatTime(date) == &quot;12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @return 格式化后的字符串
     */
    public static String formatTime(Date date) {
        return formatTime(date, locale, timeZone);
    }

    /**
     * 格式化时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.formatTime(date,Locale.CHINA) == &quot;12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @return 格式化后的字符串
     */
    public static String formatTime(Date date, Locale locale) {
        return formatTime(date, locale, timeZone);
    }

    /**
     * 格式化时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * TimeZone timeZone = TimeZone.getTimeZone(&quot;GMT+08:00&quot;);
     * DateUtil.formatTime(date,locale,timeZone) == &quot;12:23:35&quot;;
     * DateUtil.formatTime(null,null,null) == &quot;&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @param timeZone
     *            表示时区的TimeZone对象
     * @return 返回格式化后的时间
     */
    public static String formatTime(Date date, Locale locale, TimeZone timeZone) {
        if (date == null || locale == null || timeZone == null) {
            return "";
        }
        DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
        df.setTimeZone(timeZone);
        return df.format(date);
    }

    /**
     * 格式化日期
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.formatDate(date) == &quot;2008-12-11&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date) {
        return formatDate(date, locale, timeZone);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return 默认格式:yyyy-MM-dd
     * @see #formatDate(String)
     */
    public static String formatDate(String date) {
        return formatDate(date, "yyyy-MM-dd", locale);
    }

    /**
     * 格式化日期
     *
     * <pre>
     * String date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * DateUtil.formatDate(date,locale) == &quot;2008-12-11&quot;;
     * </pre>
     *
     * @param date
     *            表示日期的字符串对象
     * @param format
     *            表示时间格式:yyyy-MM-dd
     * @param locale
     *            表示国家的Locale对象
     * @return 格式化后的字符串
     */
    public static String formatDate(String date, String format, Locale locale) {
        return formatDate(parseDate(date, format), locale);
    }

    /**
     * 格式化日期
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * DateUtil.formatDate(date,locale) == &quot;2008-12-11&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date, Locale locale) {
        return formatDate(date, locale, timeZone);
    }

    /**
     * 格式化日期
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * TimeZone timeZone = TimeZone.getTimeZone(&quot;GMT+08:00&quot;);
     * DateUtil.formatDate(date,locale,timeZone) == &quot;2008-12-11&quot;;
     * DateUtil.formatDate(null,null,null) == &quot;2008-12-11&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @param timeZone
     *            表示时区的TimeZone对象
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date, Locale locale, TimeZone timeZone) {
        if (date == null || locale == null || timeZone == null) {
            return "";
        }
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        df.setTimeZone(timeZone);
        return df.format(date);
    }

    /**
     * 格式化日期和时间
     *
     * <pre>
     * String date = &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.formatDateTime(date) == &quot;2008-12-11 12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @return 格式化后的字符串
     */
    public static String formatDateTime(Date date) {
        return formatDateTime(date, locale, timeZone);
    }

    /**
     * 格式化日期和时间
     *
     * @param date
     * @return
     * @see #formatDateTime(String, Locale)
     */
    public static String formatDateTime(String date) {
        return formatDateTime(date, locale);
    }

    /**
     * 格式化日期和时间
     *
     * <pre>
     * String date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * DateUtil.formatDateTime(date,locale) == &quot;2008-12-11 12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的字符串
     * @param locale
     *            表示国家的Locale对象
     * @return 格式化后的字符串
     */
    public static String formatDateTime(String date, Locale locale) {
        return formatDateTime(parseDateTime(date), locale);
    }

    /**
     * 格式化日期和时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * DateUtil.formatDateTime(date,locale) == &quot;2008-12-11 12:23:35&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @return 格式化后的字符串
     */
    public static String formatDateTime(Date date, Locale locale) {
        return formatDateTime(date, locale, timeZone);
    }

    /**
     * 格式化日期和时间
     *
     * <pre>
     * Date date = &quot;2008-12-11 12:23:35&quot;;
     * Locale locale = locale.CHINA;
     * TimeZone timeZone = TimeZone.getTimeZone(&quot;GMT+08:00&quot;);
     * DateUtil.formatDateTime(date,locale,timeZone) == &quot;2008-12-11 12:23:35&quot;;
     * DateUtil.formatDateTime(null,null,null) == &quot;&quot;;
     * </pre>
     *
     * @param date
     *            表示日期时间的Date对象
     * @param locale
     *            表示国家的Locale对象
     * @param timeZone
     *            表示时区的TimeZone对象
     * @return 格式化后的字符串
     */
    public static String formatDateTime(Date date, Locale locale,
                                        TimeZone timeZone) {
        if (date == null || locale == null || timeZone == null) {
            return "";
        }
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
                DateFormat.MEDIUM, locale);
        df.setTimeZone(timeZone);
        return df.format(date);
    }

    /**
     * 解析字符串为Date对象<br>
     * 如果格式不符合要求或解析错误将返回null
     *
     * @param date
     * @param format
     *            字符串格式: yyyy-MM-dd
     * @return Date or null
     */
    public static Date parseDate(String date, String format) {
        Date d = null;
        if (StringUtils.isEmpty(date)) {
            return d;
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }
        return d;
    }

    /**
     * 解析字符串为Date对象，字符串必须匹配格式: yyyy-MM-dd HH:mm:ss<br>
     * 如果格式不符合要求或解析错误将返回null
     *
     * @param date
     * @return Date or null
     */
    public static Date parseDateTime(String date) {
        Date d = null;
        if (StringUtils.isEmpty(date)) {
            return d;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }
        return d;
    }

    /**
     * 返回两个日期相隔月数
     *
     * @param s
     *            格式 yyyy-MM-dd
     * @param e
     *            格式 yyyy-MM-dd
     * @return int
     */
    public static int getMonth(Date s, Date e) {
        if (s.after(e)) {
            Date t = s;
            s = e;
            e = t;
        }
        Calendar start = Calendar.getInstance();
        start.setTime(s);
        Calendar end = Calendar.getInstance();
        end.setTime(e);
        Calendar temp = Calendar.getInstance();
        temp.setTime(e);
        temp.add(Calendar.DATE, 1);

        int y = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        int m = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);

        if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {// 前后都不破月
            return y * 12 + m + 1;
        } else if ((start.get(Calendar.DATE) != 1)
                && (temp.get(Calendar.DATE) == 1)) {// 前破月后不破月
            return y * 12 + m;
        } else if ((start.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) != 1)) {// 前不破月后破月
            return y * 12 + m;
        } else {// 前破月后破月
            return (y * 12 + m - 1) < 0 ? 0 : (y * 12 + m - 1);
        }
    }

    /**
     * @return Calendar
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * 得到n天前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat f = new SimpleDateFormat(&quot;yyyy-MM-dd&quot;);
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[] dates = dateUtil.getBeforeByDays(5, f);
     * dates = {&quot;2008-01-01&quot;,
     * 			&quot;2007-12-31&quot;,
     * 			&quot;2007-12-30&quot;,
     * 			&quot;2007-12-29&quot;,
     * 			&quot;2007-12-28&quot;,
     * 			&quot;2007-12-27&quot;};
     * </pre>
     *
     * @param n
     *            天数
     * @param f
     *            日期格式对象
     * @return 格式化后的字符串数组
     */
    public String[] getBeforeByDays(int n, DateFormat f) {
        String[][] values = this.getBeforeByDays(n, new DateFormat[] { f });
        String[] new_values = new String[n + 1];
        int i = 0;
        for (String[] va : values) {
            new_values[i] = va[0];
            i++;
        }
        return new_values;
    }

    /**
     * 得到n天前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat[] fs = new DateFormat[2];
     * fs[0] = new SimpleDateFormat(&quot;MMM,dd,yyyy&quot;, Locale.US);
     * fs[1] = new SimpleDateFormat(&quot;yyyy-MM-dd&quot;);
     *
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[][] dates = dateUtil.getBeforeByDays(5, fs);
     * dates = {{&quot;Jan,01,2008&quot;,&quot;2008-01-01&quot;},
     * 			{&quot;Dec,31,2007&quot;,&quot;2007-12-31&quot;},
     * 			{&quot;Dec,30,2007&quot;,&quot;2007-12-30&quot;},
     * 			{&quot;Dec,29,2007&quot;,&quot;2007-12-29&quot;},
     * 			{&quot;Dec,28,2007&quot;,&quot;2007-12-28&quot;},
     * 			{&quot;Dec,27,2007&quot;,&quot;2007-12-27&quot;}};
     * </pre>
     *
     * @param n
     *            天数
     * @param fs
     *            日期格式对象数组
     * @return 格式化后的字符串2维数组
     */
    public String[][] getBeforeByDays(int n, DateFormat[] fs) {
        String[][] array = new String[n + 1][fs.length];
        for (int j = 0; j < fs.length; j++) {
            array[0][j] = fs[j].format(this.calendar.getTime());
        }
        for (int i = 0; i < n; i++) {
            // 当前月份等于1时
            if (this.getMonthInt() == 1 && this.getDayOfMonth() == 1) {
                // 年份往前滚动1
                calendar.roll(Calendar.YEAR, false);
            }
            if (getDayOfMonth() == 1) {
                // 月份往前滚动1
                calendar.roll(Calendar.MONTH, false);
                calendar.set(Calendar.DATE, this.getMaxDaysOfMonth());
            } else {
                calendar.roll(Calendar.DATE, false);
            }
            for (int j = 0; j < fs.length; j++) {
                array[i + 1][j] = fs[j].format(this.calendar.getTime());
            }
        }
        return array;
    }

    /**
     * 得到n月前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat f = new SimpleDateFormat(&quot;yyyy-MM&quot;);
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[] dates = dateUtil.getBeforeByMonths(5, f);
     * dates = {&quot;2008-01&quot;,
     * 			&quot;2007-12&quot;,
     * 			&quot;2007-11&quot;,
     * 			&quot;2007-10&quot;,
     * 			&quot;2007-09&quot;,
     * 			&quot;2007-08&quot;};
     * </pre>
     *
     * @param n
     *            月数
     * @param f
     *            日期格式对象
     * @return 格式化后的字符串数组
     */
    public String[] getBeforeByMonths(int n, DateFormat f) {
        String[][] values = this.getBeforeByMonths(n, new DateFormat[] { f });
        String[] new_values = new String[n + 1];
        int i = 0;
        for (String[] va : values) {
            new_values[i] = va[0];
            i++;
        }
        return new_values;
    }

    /**
     * 得到n月前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat[] fs = new DateFormat[2];
     * fs[0] = new SimpleDateFormat(&quot;MMM,yyyy&quot;, Locale.US);
     * fs[1] = new SimpleDateFormat(&quot;yyyy-MM&quot;);
     *
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[][] dates = dateUtil.getBeforeByMonths(5, fs);
     * dates = {{&quot;Jan,2008&quot;,&quot;2008-01&quot;},
     * 			{&quot;Dec,2007&quot;,&quot;2007-12&quot;},
     * 			{&quot;Nov,2007&quot;,&quot;2007-11&quot;},
     * 			{&quot;Oct,2007&quot;,&quot;2007-10&quot;},
     * 			{&quot;Sep,2007&quot;,&quot;2007-09&quot;},
     * 			{&quot;Aug,2007&quot;,&quot;2007-08&quot;}};
     * </pre>
     *
     * @param n
     *            月数
     * @param fs
     *            日期格式对象数组
     * @return 格式化后的字符串2维数组
     */
    public String[][] getBeforeByMonths(int n, DateFormat[] fs) {
        String[][] array = new String[n + 1][fs.length];
        for (int j = 0; j < fs.length; j++) {
            array[0][j] = fs[j].format(this.calendar.getTime());
        }
        for (int i = 0; i < n; i++) {
            // 当前月份等于1时
            if (this.getMonthInt() == 1) {
                // 年份往前滚动1
                calendar.roll(Calendar.YEAR, false);
                calendar.set(Calendar.MONTH, 11);
            } else {
                calendar.roll(Calendar.MONTH, false);
            }
            for (int j = 0; j < fs.length; j++) {
                array[i + 1][j] = fs[j].format(this.calendar.getTime());
            }
        }
        return array;
    }

    /**
     * 得到n天前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat f = new SimpleDateFormat(&quot;yyyy-MM-dd&quot;);
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[] dates = dateUtil.getBeforeByDays(5, f);
     * dates = {&quot;2008-01-01&quot;,
     * 			&quot;2008-01-02&quot;,
     * 			&quot;2008-01-03&quot;,
     * 			&quot;2008-01-04&quot;,
     * 			&quot;2008-01-05&quot;,
     * 			&quot;2008-01-06&quot;};
     * </pre>
     *
     * @param n
     *            天数
     * @param f
     *            日期格式对象
     * @return 格式化后的字符串数组
     */
    public String[] getAfterByDays(int n, DateFormat f) {
        String[][] values = this.getAfterByDays(n, new DateFormat[] { f });
        String[] new_values = new String[n + 1];
        int i = 0;
        for (String[] va : values) {
            new_values[i] = va[0];
            i++;
        }
        return new_values;
    }

    /**
     * 得到n天后的日期，按时间升序存放
     *
     * <pre>
     * DateFormat[] fs = new DateFormat[2];
     * fs[0] = new SimpleDateFormat(&quot;MMM,dd,yyyy&quot;, Locale.US);
     * fs[1] = new SimpleDateFormat(&quot;yyyy-MM-dd&quot;);
     *
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[][] dates = dateUtil.getAfterByDays(5, fs);
     * dates = {{&quot;Jan,01,2008&quot;,&quot;2008-01-01&quot;},
     * 			{&quot;Jan,02,2008&quot;,&quot;2008-01-02&quot;},
     * 			{&quot;Jan,03,2008&quot;,&quot;2008-01-03&quot;},
     * 			{&quot;Jan,04,2008&quot;,&quot;2008-01-04&quot;},
     * 			{&quot;Jan,05,2008&quot;,&quot;2008-01-05&quot;},
     * 			{&quot;Jan,06,2008&quot;,&quot;2008-01-06&quot;}};
     * </pre>
     *
     * @param n
     *            天数
     * @param fs
     *            日期格式对象数组
     * @return 格式化后的字符串2维数组
     */
    public String[][] getAfterByDays(int n, DateFormat[] fs) {
        String[][] array = new String[n + 1][fs.length];
        for (int j = 0; j < fs.length; j++) {
            array[0][j] = fs[j].format(this.calendar.getTime());
        }
        for (int i = 0; i < n; i++) {
            if (this.getDayOfMonth() == this.getMaxDaysOfMonth()) {
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DATE, 1);
            } else {
                calendar.roll(Calendar.DATE, 1);
            }
            for (int j = 0; j < fs.length; j++) {
                array[i + 1][j] = fs[j].format(this.calendar.getTime());
            }
        }
        return array;
    }

    /**
     * 得到n天前的日期，按时间降序存放
     *
     * <pre>
     * DateFormat f = new SimpleDateFormat(&quot;yyyy-MM&quot;);
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[] dates = dateUtil.getBeforeByDays(5, f);
     * dates = {&quot;2008-01&quot;,
     * 			&quot;2008-02&quot;,
     * 			&quot;2008-03&quot;,
     * 			&quot;2008-04&quot;,
     * 			&quot;2008-05&quot;,
     * 			&quot;2008-06&quot;};
     * </pre>
     *
     * @param n
     *            天数
     * @param f
     *            日期格式对象
     * @return 格式化后的字符串数组
     */
    public String[] getAfterByMonths(int n, DateFormat f) {
        String[][] values = this.getAfterByDays(n, new DateFormat[] { f });
        String[] new_values = new String[n + 1];
        int i = 0;
        for (String[] va : values) {
            new_values[i] = va[0];
            i++;
        }
        return new_values;
    }

    /**
     * 得到n月后的日期时间，按时间升序存放
     *
     * <pre>
     * DateFormat[] fs = new DateFormat[2];
     * fs[0] = new SimpleDateFormat(&quot;MMM,yyyy&quot;, Locale.US);
     * fs[1] = new SimpleDateFormat(&quot;yyyy-MM&quot;);
     *
     * DateUtil dateUtil = new DateUtil(&quot;2008-01-01&quot;);
     * String[][] dates = dateUtil.getAfterByMonths(5, fs);
     * dates = {{&quot;Jan,2008&quot;,&quot;2008-01&quot;},
     * 			{&quot;Feb,2008&quot;,&quot;2008-02&quot;},
     * 			{&quot;Mar,2008&quot;,&quot;2008-03&quot;},
     * 			{&quot;Apr,2008&quot;,&quot;2008-04&quot;},
     * 			{&quot;May,2008&quot;,&quot;2008-05&quot;},
     * 			{&quot;Jun,2008&quot;,&quot;2008-06&quot;}};
     * </pre>
     *
     * @param n
     *            月数
     * @param fs
     *            日期格式对象数组
     * @return 格式化后的字符串2维数组
     */
    public String[][] getAfterByMonths(int n, DateFormat[] fs) {
        String[][] array = new String[n + 1][fs.length];
        for (int j = 0; j < fs.length; j++) {
            array[0][j] = fs[j].format(this.calendar.getTime());
        }
        for (int i = 0; i < n; i++) {
            calendar.add(Calendar.MONTH, 1);
            for (int j = 0; j < fs.length; j++) {
                array[i + 1][j] = fs[j].format(this.calendar.getTime());
            }
        }
        return array;
    }

    /**
     * 得到当前日期
     *
     * @return yyyy-MM-dd
     */
    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前日期
     *
     * @return yyyyMMdd
     */
    public String getDate2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return HH:mm:ss
     */
    public String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return HHmmss
     */
    public String getTime2() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return HHmmss.SSS
     */
    public String getTime3() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss.SSS");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return HHmmssSSS
     */
    public String getTime4() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmssSSS");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return HH:mm:ss.SSS
     */
    public String getTime5() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        return df.format(this.calendar.getTime());
    }

    /**
     * 得到当前日期时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(this.calendar.getTime());
    }

    /**
     * @return 当前月份中最大的天数
     */
    public int getMaxDaysOfMonth() {
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * @return 当前月份
     */
    public int getMonthInt() {
        return 1 + calendar.get(Calendar.MONDAY);
    }

    /**
     * @return 当前年份
     */
    public static int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @return 当前月份中的天数
     */
    public int getDayOfMonth() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return 当前年份中的天数
     */
    public int getDayofYear() {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * @return 当前年份中的星期数
     */
    public int getWeekOfYear() {
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * @return 当前月份中的星期数
     */
    public int getWeekOfMonth() {
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * @return 当前星期中的天数
     */
    public int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * @return 当前时段
     */
    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @return 当前分钟段
     */
    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * @return 当前秒钟段
     */
    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * @return ERA
     */
    public int getEra() {
        return calendar.get(Calendar.ERA);
    }

    /**
     * @return ZONE_OFFSET
     */
    public int getZoneOffset() {
        return calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000);
    }

    /**
     * @return DST_OFFSET
     */
    public int getDstOffset() {
        return calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000);
    }

    /**
     * @return AM_PM
     */
    public int getAMPM() {
        return calendar.get(Calendar.AM_PM);
    }

    /**
     * @param dealDate '2013-05'
     * @return 指定月天数
     */
    public int getDayOfMonth(String dealDate) {
        Date date = parseDate(dealDate, "yyyy-MM");
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getFirstDayOfWeek(Date date){
        Calendar cal =Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //获取本周一的日期
        return cal.getTime();
    }

    /**计算两个时间之间相隔分钟数
     * @param startDate  开始时间
     * @param endDate 结束时间
     * @return
     */
    public static int getIntervalMinutes(Date startDate, Date endDate){
        if(startDate.after(endDate)){
            Date cal=startDate;
            startDate=endDate;
            endDate=cal;
        }
        long sl=startDate.getTime();
        long el=endDate.getTime();

        long ei=el-sl;
        return (int)(ei/(1000*60));
    }

    /**
     *
     * @param starTime
     * @param endTime
     * @return 2段时间差
     */
    public static StringBuffer getUserTime(Date starTime, Date endTime) {
        Long userTimes=endTime.getTime()-starTime.getTime();
        return getUserTimeByMS(userTimes);
    }
    /**
     *
     * @return 毫秒转时间差
     */
    public static StringBuffer getUserTimeByMS(Long millisecond) {
        StringBuffer userTimeStr=new StringBuffer();
        Long nd = 1000L * 24 * 60 * 60;
        Long nh = 1000L * 60 * 60;
        Long nm = 1000L * 60;
        long day = millisecond / nd;
        // 计算差多少小时
        long hour = millisecond % nd / nh;
        // 计算差多少分钟
        long min = millisecond % nd % nh / nm;
        userTimeStr.append(day).append("天").append(hour).append("时").append(min).append("分");
        return userTimeStr;
    }



    public static Date getFirstDayOfLastWeek(Date date){//获取下周第一天
        return addDays(getFirstDayOfWeek(date),7);
    }
}
