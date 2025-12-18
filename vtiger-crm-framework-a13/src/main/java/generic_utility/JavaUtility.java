package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static int generateRandomNumber() {
		return (int)(Math.random()*9999);
	}
	
	public static String genCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now); // 2025-12-18T16:40:38.866980600
//									 18122025_164038
		String currentTime = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(now);
		
		return currentTime;
	}
}
