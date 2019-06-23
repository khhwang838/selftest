package problems.hackerrank;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DayOfTheProgrammer {

	public static void main(String[] args) {
		System.out.println(dayOfProgrammer(2017));
		System.out.println(dayOfProgrammer(2016));
		System.out.println(dayOfProgrammer(1800));
		System.out.println("======================");
		System.out.println(dayOfProgrammer_2(2017));
		System.out.println(dayOfProgrammer_2(2016));
		System.out.println(dayOfProgrammer_2(1800));
		System.out.println("======================");
		System.out.println(dayOfProgrammer_3(2017));
		System.out.println(dayOfProgrammer_3(2016));
		System.out.println(dayOfProgrammer_3(1800));
		
		// TODO : 테스트 케이스 패스 실패 ...
	}
	
	static String dayOfProgrammer(int year) {

		LocalDate date = LocalDate.parse(String.valueOf(year) + "0101", DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		date = date.plusDays(255);
		
		return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
	
	static String dayOfProgrammer_2(int year) {
		
		Instant instant = Instant.parse(String.valueOf(year) + "-01-01T00:00:00.00Z");
		
		Date date = Date.from(instant.plus(255, ChronoUnit.DAYS));
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		return formatter.format(date);
		
	}
	
	static String dayOfProgrammer_3(int year) {
		Instant instant = Instant.parse(String.valueOf(year) + "-01-01T00:00:00.00Z");
		Calendar c = Calendar.getInstance();
		c.setTime(Date.from(instant));
		c.add(Calendar.DAY_OF_MONTH, 255);
		return c.toString();
//		Instant instant = c.toInstant().plus(255,  ChronoUnit.DAYS);
		
		
	}
}
