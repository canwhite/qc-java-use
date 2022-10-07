package q25_new_date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.logging.Logger;

public class Q25_NEW_DATE_TIME {
    public static void main(String[] args) {

        /***
         * LocalDate
         * LocalTime
         * LocalDateTime
         */
        LocalDate d = LocalDate.now();//当前日期
        LocalTime t = LocalTime.now();//当前时间
        LocalDateTime dt = LocalDateTime.now();//当前日期时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        /*************
        为了保持日期和时间的一致性也可以这样做
         LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
         LocalDate d = dt.toLocalDate(); // 转换到当前日期
         LocalTime t = dt.toLocalTime(); // 转换到当前时间
         */

        //---指定日期时间，of方法
        LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
        System.out.println(d2);
        LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
        System.out.println(t2);
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
        System.out.println(dt2);
        //---将字符串转化为LocalDateTime
        LocalDateTime dt3 = LocalDateTime.parse("2019-11-19T15:16:17");
        LocalDate d3 = LocalDate.parse("2019-11-19");
        System.out.println(d3);
        LocalTime t3 = LocalTime.parse("15:16:17");
        System.out.println(t3);

        /***
         *DateTimeFormatter
         * java是月和时，H5是年月日，时
         * ofPattern：意思是xxx的模式的意思of是的，pattern模式
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        //---日期加减，链式操作。plusXXX，minusXXX
        LocalDateTime dt4 = dt3.plusDays(5).minusHours(3);
        System.out.println(dt4);

        //---设置日期和时间 withXXX和with
        LocalDateTime dt5 = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        //日期变为31，月份变为9
        LocalDateTime dt6 = dt5.withMonth(9);
        System.out.println(dt6);
        //还有一个通用的with可以做一些边界操作
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);


        //---时间线之前和时间线之后
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));

        //---Duration -between和Period -until
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration duration = Duration.between(start,end);
        System.out.println(duration);

        //---Period until
        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D6



        /***
         * ZonedDateTime
         */
        //--ZonedDateTime ：一个表示时区的时间
        ZonedDateTime zdj = ZonedDateTime.now();//默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        Logger logger = Logger.getGlobal();
        logger.info(zdj.toString());
        logger.info(zny.toString());

        //--将ldt转化为zdt
        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        //默认时间
        logger.info(ldt.atZone(ZoneId.systemDefault()).toString());
        //纽约时间
        logger.info(ldt.atZone(ZoneId.of("America/New_York")).toString());


        //--时区转换，将中国时区转化为美国时区
        ZonedDateTime bj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        //将北京时间转换为纽约时间，withZoneSameInstant
        ZonedDateTime ny = bj.withZoneSameInstant(ZoneId.of("America/New_York"));

        logger.info(ny.toString());





















        


    }
}
