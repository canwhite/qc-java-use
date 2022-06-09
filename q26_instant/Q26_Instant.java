package q26_instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Logger;

public class Q26_Instant {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("时间戳");
        //--获取时间戳
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒

        //将Instant转化为时区时间
        // 以指定时间戳创建Instant:
        Instant ins = Instant.ofEpochSecond(1568568760);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]


        //转换关系
        /****
        所以，LocalDateTime，ZoneId，Instant，ZonedDateTime和long都可以互相转换：
        ┌─────────────┐
        │LocalDateTime│────┐
        └─────────────┘    │    ┌─────────────┐
                           ├───>│ZonedDateTime│
        ┌─────────────┐    │    └─────────────┘
        │   ZoneId    │────┘           ▲
        └─────────────┘      ┌─────────┴─────────┐
                             │                   │
                             ▼                   ▼
                      ┌─────────────┐     ┌─────────────┐
                      │   Instant   │<───>│    long     │
                      └─────────────┘     └─────────────┘
                转换的时候，只需要留意long类型以毫秒还是秒为单位即可。
         */
        
    }
}
