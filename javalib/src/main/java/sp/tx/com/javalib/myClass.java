package sp.tx.com.javalib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class myClass {
    public static void main(String[] args) throws Exception{


//        StringBuilder sb = getStringBuilder();

//        System.out.print(getString());
//        new Test();
//        String time = "2018年04月09日 08:12";
//        try {
//            System.out.print(getIntervalTenMinuteTime(time));
//        } catch (Exception e) {
//
//        }
//        System.out.print(getCurrentDayMorning());

//        long startTime = 1495007804947L;
//        long endTime = 1495276200000L;
//        System.out.print(getStringStartDateAndEndDate(startTime,endTime));
//        String time = "1495007804947";
//        System.out.println(getStringTime(time));
//        System.out.println(getRemidModeKeyAdoptValue("BOT推送"));
//        System.out.println(getRemidTimeKeyAdoptValue("提前5分钟",false));
//        System.out.println(getMinutesDiff("04:34","04:44"));
//        String beginTime = "2018年04月22日";
//        String endTime = "2018年04月20日";
//        String time1 = "2018-04-25 06:00:00";
//        String time2 = "2018-04-26 06:00:00";
//        getDate(beginTime,endTime,Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH);
//        getOffsetDate(beginTime, endTime, Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH);
//        System.out.println(getDateIsOneDay(beginTime,endTime,Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY));
//        System.out.println(getCurrentDayMorning(beginTime));
//        System.out.println(endTime.substring(8,10));
//        System.out.println(getHomeDate(time));
//        System.out.println(getStringStartDateAndEndDate(time1,time2));
//        System.out.println(getKeyAndValue());
//        String startTime = "2018年5月23日";
//        SimpleDateFormat format1 = new SimpleDateFormat(Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY, Locale.CHINA);
//        Date startDate = format1.parse(startTime);
//        System.out.println(getweekByDate(startDate));
        String oldVersion = "6.2.3";
        String newVersion = "6.3";
        System.out.println(compareVersion(newVersion,oldVersion));
    }
    /**
     * 比较版本号大小 3.1.1
     *
     * @param version1 新版本号
     * @param version2 旧版本号
     * @return 等于返回0，大于返回1，小于返回-1
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }

        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;

        while (index < minLen && (diff = Integer.parseInt(version1Array[index]) - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }

        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }

            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**判断给出的日期是星期几   这里要注意是闰年还是平年
     * @param date
     * @return
     * @createTime 2016年3月14日
     * @author hym
     */
    public static String getweekByDate(Date date) {
        if (date==null) {
            date=new Date();
        }
        int[] monthArr=new int[12];//月代码
        if (isLeapYear(date)) {//闰年
            monthArr=new int[]{5,1,2,5,0,3,5,1,4,6,2,4};
        }else{//平年
            monthArr=new int[]{6,2,2,5,0,3,5,1,4,6,2,4};
        }
        String dateValue=formatDate(date,"yy,MM,dd");
        String[] year_month_day=dateValue.split(",");
        int year_code=Integer.parseInt(year_month_day[0]);
        int year_value=(year_code/4+year_code)%7;//年份代码，后两位数X除以4（忽略余数）,然后与X相加，并除以7就可以了，得到的余数就是其年份代码
        int month_value=monthArr[Integer.parseInt(year_month_day[1])-1];
        int day_value=Integer.parseInt(year_month_day[2]);
        return getweek((year_value+month_value+day_value)%7);
    }

    private static String getweek(int weekvalue){
        String week=null;
        switch (weekvalue) {
            case 0:
                week="周日";
                break;
            case 1:
                week="周一";
                break;
            case 2:
                week="周二";
                break;
            case 3:
                week="周三";
                break;
            case 4:
                week="周四";
                break;
            case 5:
                week="周五";
                break;
            case 6:
                week="周六";
                break;

            default:
                break;
        }
        return week;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern  格式化后的日期格式
     * @return
     * @createTime 2016年3月14日
     * @author hym
     */
    private static String formatDate(Date date, String pattern) {// yyyy/MM/dd
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 判断是否为闰年 闰年返回true
     *
     * @param date
     * @return
     * @createTime 2016年3月14日
     * @author hym
     */
    private static boolean isLeapYear(Date date) {
        //1.能被400整除的年份； 2.能被4整除但同时不能被100整除的年份  满足之一即是闰年
        Integer year = Integer.parseInt(formatDate(date, "yyyy"));
        return year%4==0&&year%100!=0||year%400==0;
    }











































































    /**
     * 获取开始和结束时间：同一天返回 几月几日 几时几分 - 几时几分，非同一天返回几月几日 几时几分 - 几月几日 几时几分
     */
    public static String getStringStartDateAndEndDate(String startTime, String endTime) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat(Constant.HOME_EVENT_DETAILS_TIME, Locale.CHINA);
            SimpleDateFormat format2 = new SimpleDateFormat(Constant.EVENT_DETAILS_TIME_SHOW, Locale.CHINA);
            SimpleDateFormat format3 = new SimpleDateFormat(Constant.HOME_EVENT_DETAILS_TIME_SHOW, Locale.CHINA);
            SimpleDateFormat format4 = new SimpleDateFormat(Constant.TIME_FORMAT_TYPE_TIME, Locale.CHINA);
            Date startDate = format1.parse(startTime);
            Date endDate = format1.parse(endTime);
            if (getDateIsOneDay(getHomeFromAndToTime(startTime,Constant.HOME_EVENT_DETAILS_TIME,Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY),getHomeFromAndToTime(endTime,Constant.HOME_EVENT_DETAILS_TIME,Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY),Constant.TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY)) {
                return format2.format(startDate) + " " + format3.format(startDate) + "-" + format3.format(endDate);
            } else {
                return format4.format(startDate) + " - " + format4.format(endDate);
            }
        }catch (Exception e){
            return "";
        }
    }
    /**
     * 首页开始和结束时间格式化
     */
    public static String getHomeFromAndToTime(String time, String oldFormat, String newFormat) {
        SimpleDateFormat format = new SimpleDateFormat(oldFormat, Locale.CHINA);
        SimpleDateFormat format2 = new SimpleDateFormat(newFormat, Locale.CHINA);
        Date date = null;
        try {
            date = format.parse(time);
            return format2.format(date);
        } catch (Exception e) {
            return "";
        }
    }
//    public static String getHomeDate(String time){
//        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA);
//        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm", Locale.CHINA);
//        Date date = null;
//        try {
//            date = format.parse(time);
//            return format2.format(date);
//        }catch (Exception e){
//            return "";
//        }
//    }

    /**
     * 获取开始和结束时间：同一天返回 几月几日 几时几分 - 几时几分，非同一天返回几月几日 几时几分 - 几月几日 几时几分
     */
    public static String getStringStartDateAndEndDate(long startTime, long endTime,String currentDateTime) {
        SimpleDateFormat format1 = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm", Locale.CHINA);
        SimpleDateFormat format3 = new SimpleDateFormat(Constant.TIME_FORMAT_TYPE_TIME, Locale.CHINA);
        Calendar startC = Calendar.getInstance();
        Calendar endC = Calendar.getInstance();
        startC.setTimeInMillis(startTime);
        endC.setTimeInMillis(endTime);
        Date startDate = startC.getTime();
        Date endDate = endC.getTime();
        if (format1.format(startDate).equals(format1.format(endDate))) {
            startC.set(Calendar.DAY_OF_MONTH,Integer.valueOf(currentDateTime.substring(6,8)));
            Date startNewDate = startC.getTime();
            return format1.format(startNewDate) + " " + format2.format(startDate) + "-" + format2.format(endDate);
        } else {
            return format3.format(startDate) + " - " + format3.format(endDate);
        }
    }
    /**
     * 获取当天的0点的时间
     */
    public static String getCurrentDayMorning(String time) {
        String day = subString(time,"月","日");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat(Constant.TIME_FORMAT_TYPE, Locale.CHINA);
        return format.format(calendar.getTime());
    }
    /**
     * 截取字符串str中指定字符 strStart、strEnd之间的字符串
     *
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
    public static String subString(String str, String strStart, String strEnd) {

        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }


    /**
     * 获取当天的最后一秒的时间
     */
    public static String getCurrentDayNight(String time) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        SimpleDateFormat format = new SimpleDateFormat(Constant.TIME_FORMAT_TYPE, Locale.CHINA);
        return format.format(calendar.getTime());
    }
    public static boolean getDateIsOneDay(String beginTime,String endTime,String timeFormatType) {
        boolean isOneDay = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat(timeFormatType, Locale.CHINA);
            Date startDate = format.parse(beginTime);
            Date endDate = format.parse(endTime);
            if(format.format(startDate).equals(format.format(endDate))){
                isOneDay = true;
            }else{
                isOneDay = false;
            }
        }catch (Exception e){

        }
        return isOneDay;
    }

    public static void getOffsetDate(String beginTime, String endTime, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType, Locale.CHINA);
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(beginTime);
            endDate = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(calcDayOffset(beginDate, endDate));
        System.out.println(calcWeekOffset(beginDate, endDate));
    }

    /**
     * @param date1
     * @param date2
     * @return date2与date1相差多少天
     */
    public static int calcDayOffset(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {  //同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                    timeDistance += 366;
                } else {  //不是闰年

                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else { //不同年
            return day2 - day1;
        }
    }

    /**
     * date2比date1多的周数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calcWeekOffset(Date startTime, Date endTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek - 1;
        if (dayOfWeek == 0) dayOfWeek = 7;

        int dayOffset = calcDayOffset(startTime, endTime);

        int weekOffset = dayOffset / 7;
        int a;
        if (dayOffset > 0) {
            a = (dayOffset % 7 + dayOfWeek > 7) ? 1 : 0;
        } else {
            a = (dayOfWeek + dayOffset % 7 < 1) ? -1 : 0;
        }
        weekOffset = weekOffset + a;
        return weekOffset;
    }

    /**
     * 返回二个时间相差的分分钟数,如果一个为空，返回为0；
     *
     * @param startDate，比如08：09
     * @param endDate，如18：09
     * @return
     */
    public static int getMinutesDiff(String startDate, String endDate) {
        int ret = 0;
//        if(RStringUtils.isEmpty(startDate) || RStringUtils.isEmpty(endDate)){
//            // return ret;
//        }else{
        String startDateStr[] = startDate.split(":");
        String endDateStr[] = endDate.split(":");
        if (startDateStr[0].startsWith("0")) {
            startDateStr[0] = startDateStr[0].substring(1);
        }
        if (startDateStr[1].startsWith("0")) {
            startDateStr[1] = startDateStr[1].substring(1);
        }
        if (endDateStr[0].startsWith("0")) {
            endDateStr[0] = endDateStr[0].substring(1);
        }
        if (endDateStr[1].startsWith("0")) {
            endDateStr[1] = endDateStr[1].substring(1);
        }
        int s = Integer.parseInt(startDateStr[0]) * 60 + Integer.parseInt(startDateStr[1]);
        int e = Integer.parseInt(endDateStr[0]) * 60 + Integer.parseInt(endDateStr[1]);
        ret = e - s;
//        }
        return ret;

    }

    /**
     * 根据value获取对应的key
     */
    public static String getRemidModeKeyAdoptValue(String value) {
        Map<String, String> map = new HashMap<>();
        map.put("bot", Constant.EVENT_REMIND_MODE_VALUE_NOTICE);
        map.put("sms", Constant.EVENT_REMIND_MODE_VALUE_SMS);
        map.put("email", Constant.EVENT_REMIND_MODE_VALUE_EMAIL);
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }

    /**
     * 根据value获取对应的key
     */
    public static String getRemidTimeKeyAdoptValue(String value, boolean isAllDay) {
        Map<String, String> mapAllDay = new HashMap<>();
        mapAllDay.put("on_eight", Constant.EVENT_REMIND_CURRENT_EIGHT_ALL_DAY);
        mapAllDay.put("on_nine", Constant.EVENT_REMIND_CURRENT_NINE_ALL_DAY);
        mapAllDay.put("pre_eight", Constant.EVENT_REMIND_ONE_DAY_AGO_EIGHT_ALL_DAY);
        mapAllDay.put("pre_nine", Constant.EVENT_REMIND_ONE_DAY_AGO_NINE_ALL_DAY);
        mapAllDay.put("pre_week_eight", Constant.EVENT_REMIND_ONE_WEEK_AGO_EIGHT_ALL_DAY);
        Map<String, String> mapNoAllDay = new HashMap<>();
        mapNoAllDay.put("on_time", Constant.EVENT_REMIND_TIME_VALUE_START);
        mapNoAllDay.put("five_minutes", Constant.EVENT_REMIND_TIME_VALUE_FIVE);
        mapNoAllDay.put("ten_minutes", Constant.EVENT_REMIND_TIME_VALUE_TEN);
        mapNoAllDay.put("thirty_minutes", Constant.EVENT_REMIND_TIME_VALUE_THIRTY);
        mapNoAllDay.put("one_day", Constant.EVENT_REMIND_TIME_VALUE_ONE_DAY);
        String key = "";
        if (isAllDay) {
            for (Map.Entry<String, String> entry : mapAllDay.entrySet()) {
                if (value.equals(entry.getValue())) {
                    key = entry.getKey();
                }
            }
        } else {
            for (Map.Entry<String, String> entry : mapNoAllDay.entrySet()) {
                if (value.equals(entry.getValue())) {
                    key = entry.getKey();
                }
            }
        }
        return key;
    }



    public static String getKeyAndValue(String value,String string) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1s");
        map.put("2", "2s");
        map.put("3", "3s");
        map.put("4", string);
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
//        Map<String,String> map = new HashMap<>();
//        map.put("1","1s");
//        map.put("2","2s");
//        map.put("3","3s");
//        map.put("4","4s");
//        return map.get(key);
    }

    public static String getStringStartDateAndEndDate(long startTime, long endTime) {
        SimpleDateFormat format1 = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm", Locale.CHINA);
        SimpleDateFormat format3 = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);
        Calendar startC = Calendar.getInstance();
        Calendar endC = Calendar.getInstance();
        startC.setTimeInMillis(startTime);
        endC.setTimeInMillis(endTime);
        Date startDate = startC.getTime();
        Date endDate = endC.getTime();
        if (format1.format(startDate).equals(format1.format(endDate))) {
            return format1.format(startDate) + " " + format2.format(startDate) + "-" + format2.format(endDate);
        } else {
            return format3.format(startDate) + " - " + format3.format(endDate);
        }
    }

    /**
     * 获取给定时间提前10分钟的时间
     */
    public static String getIntervalTenMinuteTime(String time) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.CHINA);
        Date parseDate = simpleDateFormat.parse(time);
        // 设置Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate);

        int oldTime = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, oldTime - 10);
        // 转换格式
        String format = simpleDateFormat.format(calendar.getTime());
        return format;
    }


    public static String getCurrentDayMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.CHINA);
        return format.format(calendar.getTime());
    }

    //获得当天0点时间
    public static int getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天24点时间
    public static int getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /**
     * 时间格式转换
     */
    public static String getTimeFormatConversion(String time) throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Date strtodate = format1.parse(time);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return format2.format(strtodate);
    }

    /**
     * 时间格式转换
     */
    public static String getStringTime(String time) {
        SimpleDateFormat format1 = new SimpleDateFormat("MM月dd日 HH:mm");
        Date date = new Date();
        date.setTime(Long.parseLong(time));
        return format1.format(date);
    }


    static class Base {
        static {
            System.out.print("3");
        }

        public Base() {
            System.out.print("4");
        }
    }

    static class Test extends Base {
        static {
            System.out.print("1");
        }

        public Test() {
            System.out.print("2");
        }
    }

    private static String getString() {
        String str = "公积金,人事,行政";
        String str1 = str.replace(",", "/");
        return str1;
    }

    private static StringBuilder getStringBuilder() {
        String str = "公积金,人事,行政";
        String[] tags = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tags.length; i++) {
            sb.append(tags[i]);
            sb.append("/");
        }
        return sb;
    }

    public static void getDate(String beginTime, String endTime, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType, Locale.CHINA);
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(beginTime);
            endDate = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l = endDate.getTime() - beginDate.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = day * 24;
        long mon = day / 30;
        long year = mon / 12;
        System.out.println("相差" + hour + "小时");
//        System.out.println("相差" + day + "天");
//        System.out.println("相差" + mon + "月");
//        System.out.println("相差" + year + "年");
    }

}
