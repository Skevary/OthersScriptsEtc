import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestMain {
	private static ResourceBundle message = ResourceBundle.getBundle("language", new Locale("en"));
	private static final Logger log = Logger.getLogger(TestMain.class);
	private static String[] defaultMessage = {
			"Good morning, World!",
			"Good day, World!",
			"Good evening, World!",
			"Good night, World!" };

	@BeforeClass
	public static void allTestsStarted() {
		log.info("All tests started.");
	}

	@AfterClass
	public static void allTestsFinished() {
		log.info("All tests finished.");
	}

	@Test
	public void testSetAllTime() {
		log.info("Start testSetAllTime.");
		for (int hour = 0; hour <= 24; hour++) {
			if (hour >= 6 && hour < 9)
				Assert.assertEquals(Main.showMessage(hour), defaultMessage[0]);
			else if (hour >= 9 && hour < 19)
				Assert.assertEquals(Main.showMessage(hour), defaultMessage[1]);
			else if (hour >= 19 && hour < 23)
				Assert.assertEquals(Main.showMessage(hour), defaultMessage[2]);
			else
				Assert.assertEquals(Main.showMessage(hour), defaultMessage[3]);
		}
	}
	
	@Test
	public void testSetIntegerTime() {
		log.info("Start testSetIntegerTime.");
		Assert.assertEquals(Main.showMessage(new Integer(23)), defaultMessage[3]);
		}

	@Test
	public void testSetLocaleFake() {
		log.info("Start testSetLocaleFake.");
		message = ResourceBundle.getBundle("language", new Locale("fake"));

		Assert.assertEquals(message.getString("morning"), defaultMessage[0]);
		Assert.assertEquals(message.getString("day"), defaultMessage[1]);
		Assert.assertEquals(message.getString("evening"), defaultMessage[2]);
		Assert.assertEquals(message.getString("night"), defaultMessage[3]);
	}

	@Test
	public void testSetLocaleRU() {
		log.info("Start testSetLocaleRU.");
		message = ResourceBundle.getBundle("language", new Locale("ru"));

		Assert.assertEquals(message.getString("morning"), "Доброе утро, Мир!");
		Assert.assertEquals(message.getString("day"), "Добрый день, Мир!");
		Assert.assertEquals(message.getString("evening"), "Добрый вечер, Мир!");
		Assert.assertEquals(message.getString("night"), "Доброй ночи, Мир!");
	}
}