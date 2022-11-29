import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public static int getDay(Date date) throws Exception {
		String s = formatter.format(date);
		String[] arr = s.split("-");
		if (arr.length != 3)
			throw new Exception("Invalid time format");
		return Integer.valueOf(arr[0]);
	}

	public static int getMonth(Date date) throws Exception {
		String s = formatter.format(date);
		String[] arr = s.split("-");
		if (arr.length != 3)
			throw new Exception("Invalid time format");
		return Integer.valueOf(arr[1]);
	}
	
	public static int getYear(Date date) throws Exception {
		String s = formatter.format(date);
		String[] arr = s.split("-");
		if (arr.length != 3)
			throw new Exception("Invalid time format");
		return Integer.valueOf(arr[2]);
	}
	

	public static int getMinute(Time time) throws Exception {
		String s = time.toString();
		String arr[] = s.split(":");
		if (arr.length != 3)
			throw new Exception("Invalid time format");
		int hour = Integer.valueOf(arr[0]);
		int minute = Integer.valueOf(arr[1]);
		return hour * 60 + minute;
	}
}