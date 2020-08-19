package pl.stormit.kp.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateApp {
	public static void main(String[] args) {
		localTime();
		zonedTime();
		unixTime();
		formattedTime();
	}

	private static void localTime() {
		System.out.println("\n\n==> LocalTime ===================");

		// current local time
		LocalDateTime now = LocalDateTime.now();
		System.out.println(String.format("LocalDateTime now: \t\t%s", now));

		// operations on time
		LocalDateTime oneHourLater = now.plusHours(1);
		LocalDateTime twoYearsAgo = now.minusYears(2);
		LocalDateTime fiveMonthsLater = now.plus(5, ChronoUnit.MONTHS);
		System.out.println(String.format("LocalDateTime two months later: \t%s", twoYearsAgo));

		// specific time
		LocalDateTime definedDateTime = LocalDateTime
				.of(2020, Month.MARCH, 1, 12, 45, 59);
		System.out.println(String.format("Specific LocalDateTime: \t%s", definedDateTime));
	}

	private static void zonedTime() {
		System.out.println("\n\n==> ZonedTime ===================");

		ZoneId zoneLocal = ZoneId.systemDefault();
		ZoneId zoneTokyo = ZoneId.of("Asia/Tokyo");

		System.out.println(String.format("Local zone: %s,\nTokyo zone: %s", zoneLocal, zoneTokyo));

		ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
		System.out.println(String.format("ZonedDateTime now (local): %s", zonedDateTimeNow));

		ZonedDateTime zonedDateTimeTokyo = zonedDateTimeNow.withZoneSameInstant(zoneTokyo);
		System.out.println(String.format("ZonedDateTime now (Tokyo): %s", zonedDateTimeTokyo));
	}

	private static void unixTime() {
		System.out.println("\n\n==> UnixTime ===================");

		long seconds = Instant.now().getEpochSecond();
		long minutes = seconds / 60;
		long hours = minutes / 60;
		long days = hours / 24;
		long years = days / 365;

		System.out.println(String.format("seconds: \t%d\nminutes: \t%d\nhours: \t\t%d\ndays: \t\t%d\nyears: \t\t%d\n", seconds, minutes, hours, days, years));

		Instant instantZero = Instant.ofEpochSecond(0);
		System.out.println(String.format("UnixTime 0: %s", instantZero));
	}

	private static void formattedTime() {
		System.out.println("\n\n==> FormattedTime ===================");

		ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

		String formattedDateTimeNow = zonedDateTimeNow.format(formatter);
		System.out.println(String.format("FormattedDateTime: \t\t\t%s", formattedDateTimeNow));

		String definedTime = "2020-07-01T07:50:27+0200";
		ZonedDateTime zonedDateTimeDefined = ZonedDateTime.parse(definedTime, formatter);
		System.out.println(String.format("ZonedDateTimeDefined:\t\t%s", zonedDateTimeDefined));
	}
}
