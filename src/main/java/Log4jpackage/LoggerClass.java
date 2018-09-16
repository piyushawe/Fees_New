package Log4jpackage;

import org.apache.log4j.Logger;

public class LoggerClass {
   public static Logger log_error=Logger.getLogger("");/** This object is use to log error,fatal in the file */
   public static Logger log_info=Logger.getLogger("Error_log");/** This object is use to log info,warn,trace
    on the console */
}
