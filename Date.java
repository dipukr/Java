import java.text.SimpleDateFormat;
import java.sql.Time;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Date {

	public class Period {
		public Date fromDate;
		public Date toDate;
		public Time fromTime;
		public Time toTime;
		public Float quantum;
	}
	
	public boolean isOverlaping(List<Period> periods) throws Exception {
		Map<Integer, Map<Integer, Map<Integer, Float>>> map = new TreeMap<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date currDate = formatter.parse("24-08-2022");

		for (Period period: periods) {
			int month = DateUtil.getMonth(quantumData.fromDate);
			if (!map.containsKey(month))
				map.put(month, new TreeMap<Integer, Map<Integer, Float>>());
			int startDay = DateUtil.getDay(period.fromDate);
			int endDay = DateUtil.getDay(period.toDate);
			for (int day = startDay; day <= endDay; day++) {
				if (!map.get(month).containsKey(day))
					map.get(month).put(day, new TreeMap<Integer, Float>());
				int startMinute = DateUtil.getMinute(period.fromTime);
				int endMinute = DateUtil.getMinute(period.toTime);
				for (int minute = startMinute; minute <= endMinute; minute++) {
					if (map.get(month).get(day).containsKey(minute)) {
						return true;
					else map.get(month).get(day).put(minute, period.quantum); 
				}
			}
		}		
	}
	return false;
}
