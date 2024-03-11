package util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerUtil {

	protected static final Logger logger = LogManager.getLogger(Listener.class);

	/**
	 * Logs info into the log file
	 */
	public static void info(String message) {
		logger.info(message);
	}

	/**
	 * Logs error into the log file
	 */
	public static void error(String message) {

		logger.error(message);
	}

}
