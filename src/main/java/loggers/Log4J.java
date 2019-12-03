package loggers;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Log4J {
    private Logger logger;
    private String msg;

    void doStnk() {
        msg = "Logger";
        logger.getLogger("Log4J").log(Level.INFO, msg);
    }

}
