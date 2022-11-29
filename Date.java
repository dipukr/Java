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

public class ControllerLayer {

	@Setter
	@Getter
	@ToString
	public class QuantumData {

		private Date fromDate;
		private Date toDate;
		
		private Time fromTime;
		private Time toTime;
		
		private Float quantum;
	}
	
	public boolean isOverlaping(List<QuantumData> quantumDatas) throws Exception {
		Map<Integer, Map<Integer, Map<Integer, Float>>> map = new TreeMap<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date currDate = formatter.parse("24-08-2022");

		for (QuantumData quantumData: quantumDatas) {
			int month = DateUtil.getMonth(quantumData.getFromDate());
			if (!map.containsKey(month))
				map.put(month, new TreeMap<Integer, Map<Integer, Float>>());
			int startDay = DateUtil.getDay(quantumData.getFromDate());
			int endDay = DateUtil.getDay(quantumData.getToDate());
			for (int day = startDay; day <= endDay; day++) {
				if (!map.get(month).containsKey(day))
					map.get(month).put(day, new TreeMap<Integer, Float>());
				int startMinute = DateUtil.getMinute(quantumData.getFromTime());
				int endMinute = DateUtil.getMinute(quantumData.getToTime());
				for (int minute = startMinute; minute <= endMinute; minute++) {
					if (map.get(month).get(day).containsKey(minute)) {
						return true;
					else map.get(month).get(day).put(minute, quantumData.getQuantum()); 
				}
			}
		}		
	}
	return false;
}
