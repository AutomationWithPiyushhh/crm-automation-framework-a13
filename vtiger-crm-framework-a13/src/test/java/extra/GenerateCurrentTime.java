package extra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateCurrentTime {
	public static void main(String[] args) {
	 LocalDateTime now = LocalDateTime.now();
	 String currentTime = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(now);
	 System.out.println(currentTime);
	 
	 
	 
	 System.out.println(now);
//	 2025-12-08T13:42:22.223317200
//	 08122025_134250
	}
}
