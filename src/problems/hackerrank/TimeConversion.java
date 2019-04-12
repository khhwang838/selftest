/**
 * Created on Apr 12, 2019 by Keichee
 */
package problems.hackerrank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;

public class TimeConversion {

	public static void main(String[] args) {
		Assert.assertEquals("00:05:45", timeConversion("12:05:45AM"));
		Assert.assertEquals("12:05:45", timeConversion("12:05:45PM"));
		
		Assert.assertEquals("07:05:00", timeConversion("07:05:00AM"));
		Assert.assertEquals("19:05:45", timeConversion("07:05:45PM"));
	}
	static String timeConversion(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		if(s.endsWith("PM")) {
			s = s.replace("PM", "");
			LocalTime time = LocalTime.parse(s, formatter);
			if(s.startsWith("12")) {
				return time.format(formatter);
			} else {
				return time.plusHours(12).format(formatter);
			}
		} else {
			s = s.replace("AM", "");
			LocalTime time = LocalTime.parse(s, formatter);
			if(s.startsWith("12")) {
				return time.plusHours(12).format(formatter);
			} else {
				return time.format(formatter);
			}
		}
    }
}
