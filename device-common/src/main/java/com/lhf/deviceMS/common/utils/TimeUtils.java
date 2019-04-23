package com.lhf.deviceMS.common.utils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author mjy
 * @Description
 * @Date 2019/3/28 10:20
 * @Version 1.0
 **/
public class TimeUtils {

    //LocalDate   LocalTime   LocalDateTime

    //now相关的方法可以获取当前日期或时间，
    // of方法可以创建对应的日期或时间，
    // parse方法可以解析日期或时间，
    // get方法可以获取日期或时间信息，
    // with方法可以设置日期或时间信息，
    // plus或minus方法可以增减日期或时间信息

    //TemporalAdjusters 这个类在日期调整时非常有用

    // DateTimeFormatter 格式化日期使用

    //格式化日期
    public static final String  DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    //默认
    private static final String DEFAULT_PATTERN = DATE_TIME;

    /**
     * 格式化当前日期
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern){
        return TimeUtils.formatTime(LocalDateTime.now(),pattern);
    }

    public static String formatNow(){
        return formatNow(DEFAULT_PATTERN);
    }

    /**
     * 格式化一个Date对象
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date,String pattern){
        LocalDateTime localDateTime = conveter2LocalDateTime(date);
        String format = formatTime(localDateTime, pattern);
        return format;
    }

    public static String formatDate(Date date){
        LocalDateTime localDateTime = conveter2LocalDateTime(date);
        String format = formatTime(localDateTime, DEFAULT_PATTERN);
        return format;
    }

    /**
     * 格式化Calendar对象
     * @param calendar
     * @param pattern
     * @return
     */
    public static String formatCalendar(Calendar calendar,String pattern){
        LocalDateTime localDateTime = conveter2LocalDateTime(calendar);
        String format = formatTime(localDateTime, pattern);
        return format;
    }


    public static String formatCalendar(Calendar calendar){
        LocalDateTime localDateTime = conveter2LocalDateTime(calendar);
        String format = formatTime(localDateTime, DEFAULT_PATTERN);
        return format;
    }

    /**
     * 获取10位时间戳
     * @return
     */
    public static long current10Milli(){
        return current13Milli()/1000;
    }

    /**
     * 获取13位时间戳
     * @return
     */
    public static long current13Milli(){
        /*return System.currentTimeMillis();*/
        return Clock.systemDefaultZone().millis();
    }

    /**
     * 字符串转换成LocalDateTime
     * @param time
     * @param pattern
     * @return
     */
    public static LocalDateTime conveter(String time,String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        TemporalAccessor parse = dateTimeFormatter.parse(time);
        LocalDateTime from = LocalDateTime.from(parse);
        return from;
    }

    /**
     * 某月第一天  TeporalAdjuster中提供了很多日常方便操作，看源码哦！
     * @param localDateTime
     * @return
     */
    public static String firstDayOfMonth(LocalDateTime localDateTime){
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
        LocalDateTime with = localDateTime.with(temporalAdjuster);
        return formatTime(with, DEFAULT_PATTERN);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date currentTime(){
        return new Date();
    }





    private static LocalDateTime conveter2LocalDateTime(Calendar calendar) {
        LocalDateTime localDateTime = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return localDateTime;
    }

    private static LocalDateTime conveter2LocalDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return conveter2LocalDateTime(calendar);
    }

    private static String formatTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

}
