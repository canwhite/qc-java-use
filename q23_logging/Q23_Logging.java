package q23_logging;

import java.util.logging.Logger;

public class Q23_Logging {
    public static void main(String[] args) {
        /**
            java官方标准库提供的JDK Logging
            当然还有三方的类似
            Commons Logging
            Log4j
            SLF4J和Logback
         */

        //实际上需要使用的就Logger和getGlobal
        Logger logger = Logger.getGlobal();
        //普通信息
        logger.info("start process...");
        //警告
        logger.warning("memory is running out...");
        //忽视
        logger.fine("ignored.");
        //严重
        logger.severe("process will be terminated...");

    }
}
