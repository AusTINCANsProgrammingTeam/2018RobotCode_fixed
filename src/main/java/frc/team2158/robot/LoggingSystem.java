package frc.team2158.robot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
/**
 * @version 0.0.1
 * @author William Blount
 * Manages robot code logging and where the output is sent.
 */
public class LoggingSystem {
    private static final Logger LOGGER = Logger.getLogger(LoggingSystem.class.getName());
    private static final class CustomFormatter extends Formatter {
        private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");


        @Override
        public String format(LogRecord record) {
            return MessageFormat.format("{0} - [{1}::{2}] - [{3}] - {4}\n",
                    dateFormat.format(new Date(record.getMillis())), record.getSourceClassName(),
                    record.getSourceMethodName(), record.getLevel(), record.getMessage());
        }
    }
    private static final Formatter FORMATTER = new CustomFormatter();

    private static LoggingSystem instance;

    private LoggingSystem(String outputPath) throws IOException {
        Logger logger = Logger.getLogger("");


        for(Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }


        ConsoleHandler consoleHandler = new ConsoleHandler() {{
            setFormatter(FORMATTER);
        }};
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler(outputPath) {{
            setFormatter(FORMATTER);
        }};
        logger.addHandler(fileHandler);

        LOGGER.info("Initialized logging system.");
    }


    public static LoggingSystem getInstance() {
        if(instance == null) {
            try {
                instance = new LoggingSystem("/home/lvuser/output.log");
            }
            catch(IOException e) {
                throw new RuntimeException("Unable to start logging system. Error is as follows:\n" + e.toString());
            }
        }
        return instance;
    }
}
