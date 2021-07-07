package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
	
	public static String formatDate(Date data) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(data);
	}
}
