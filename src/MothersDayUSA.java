import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class MothersDayUSA {
	
	private LocalDate mothersDayDate;

	public MothersDayUSA(int year) {
		letsCalculate(year);
	}

	private void letsCalculate(int year) {
		
		LocalDate date = LocalDate.of(year, Month.MAY, 01);
		
		LocalDate firstSunday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
			
		mothersDayDate = firstSunday.plusWeeks(1);
		
	}

	public LocalDate getMothersDayDate() {
		return mothersDayDate;
	}

	// Only possible to set the year - and this should trigger a recalculation
	public void setYear(int year) {
		letsCalculate(year);
	}

	/** Override the toString() method from the Object Class and parent Class */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		return mothersDayDate.format(formatter);
	}

	/** Override the equals() method from the Object class */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MothersDayUSA) {
			MothersDayUSA otherDate = (MothersDayUSA) obj;
			return (mothersDayDate.equals(otherDate.getMothersDayDate()));
		} else {
			return false;
		}
	}
}
