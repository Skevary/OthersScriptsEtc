import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	private static final ResourceBundle message = ResourceBundle.getBundle("language");

	public static String showMessage(int hour) {
		if (hour >= 6 && hour < 9)
			return message.getString("morning");
		else if (hour >= 9 && hour < 19)
			return message.getString("day");
		else if (hour >= 19 && hour < 23)
			return message.getString("evening");
		else
			return message.getString("night");
	}

	public static void main(String[] args) {
		log.info("The program started.");

		int currentHour = LocalDateTime.now().getHour();
		log.info("Current time: " + currentHour + " o'clock.");

		System.out.println(showMessage(currentHour));
		log.info("Printed in the console: '" + showMessage(currentHour) + "'.");

		log.info("The program completed it's work.");
	}
}
