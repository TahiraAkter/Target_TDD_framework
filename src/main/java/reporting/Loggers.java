package reporting;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Reporter;

public class Loggers {

	static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void getLog(String msg) {

		logger.log(Level.INFO, msg);// this is from Java Console Log//It will show some INFO and msg

		Reporter.log(msg);// TestNG Reporter log
	}

}
