import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MothersDayUK {

	private LocalDate mothersDayDate;

	public MothersDayUK(int year) {
		letsCalculate(year);
	}

	private void letsCalculate(int year) {
		int month = calcMonth(year);
		int dayOfMonth = calcDayOfMonth(year);


		LocalDate easterDate = LocalDate.of(year, month, dayOfMonth);
		mothersDayDate = easterDate.minusWeeks(3);
	}

	private int calcMonth(int year) {
		int a = year % 19, b = year / 100, c = year % 100, d = b / 4, e = b % 4, g = (8 * b + 13) / 25,
				h = (19 * a + b - d - g + 15) % 30, j = c / 4, k = c % 4, m = (a + 11 * h) / 319,
				r = (2 * e + 2 * j - k - h + m + 32) % 7, n = (h - m + r + 90) / 25;
		return n;
	}

	private int calcDayOfMonth(int year) {
		int a = year % 19, b = year / 100, c = year % 100, d = b / 4, e = b % 4, g = (8 * b + 13) / 25,
				h = (19 * a + b - d - g + 15) % 30, j = c / 4, k = c % 4, m = (a + 11 * h) / 319,
				r = (2 * e + 2 * j - k - h + m + 32) % 7, n = (h - m + r + 90) / 25, p = (h - m + r + n + 19) % 32;
		return p;
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
		if (obj instanceof MothersDayUK) {
			MothersDayUK otherDate = (MothersDayUK) obj;
			return (mothersDayDate.equals(otherDate.getMothersDayDate()));
		} else {
			return false;
		}
	}
}
