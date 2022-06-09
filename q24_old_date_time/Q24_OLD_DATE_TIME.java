package q24_old_date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Q24_OLD_DATE_TIME {
    public static void main(String[] args) {
        /*********
            时间本质上是从1970年开始的时间戳 epoch time
            然后多标准api，实际上是一个display方法
         ************/

        //---date
        //获取当前时间
        Date date = new Date();
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1

        //---calendar -更方便对时间设置
        Calendar c = Calendar.getInstance();
        //格式化,这里需要一个c.getTime
        //利用calendar.getTime方法可以将一个Calendar对象转化为Date对象
        System.out.println(sdf.format(c.getTime()));

        int y = c.get(Calendar.YEAR);//获取年
        int m = c.get(Calendar.MONTH)+1;//获取月
        //天、周和小时，这几个of
        int d = c.get(Calendar.DAY_OF_MONTH);//获取天
        int w = c.get(Calendar.DAY_OF_WEEK);//获取周
        int hh = c.get(Calendar.HOUR_OF_DAY);//获取小时
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);


        //重新设置时间
        //要想设置成特定的一个时间和日期，就必须先清除所有字段
        c.clear();
        //设置成2019
        c.set(Calendar.YEAR,2019);
        //设置成9月，注意8表示9月
        c.set(Calendar.MONTH,8);
        // 设置2日:
        c.set(Calendar.DATE, 2);
        // 设置时间:
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 23);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));


        //TimeZone - 有了时区的能力
        //getDefault和getTimeZone
        TimeZone tzDefault = TimeZone.getDefault();  //当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");//GMT+09:00 时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York

    }
}


