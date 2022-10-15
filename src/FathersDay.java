
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class FathersDay {
	
	private LocalDate fathersDayDate;

	public FathersDay(int year) {
		letsCalculate(year);
	}

	private void letsCalculate(int year) {
		
		LocalDate date = LocalDate.of(year, Month.JUNE, 01);
		
		LocalDate firstSunday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
			
		fathersDayDate = firstSunday.plusWeeks(2);
		System.out.println("fathers day USA" + fathersDayDate);
		
	}

	public LocalDate getFathersDayDate() {
		return fathersDayDate;
	}

	// Only possible to set the year - and this should trigger a recalculation
	public void setYear(int year) {
		letsCalculate(year);
	}

	/** Override the toString() method from the Object Class and parent Class */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		return fathersDayDate.format(formatter);
	}

	/** Override the equals() method from the Object class */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FathersDay) {
			FathersDay otherDate = (FathersDay) obj;
			return (fathersDayDate.equals(otherDate.getFathersDayDate()));
		} else {
			return false;
		}
	}
}
