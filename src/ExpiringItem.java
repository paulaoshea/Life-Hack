import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpiringItem implements Comparable<ExpiringItem> {
	
	private String description;
	private LocalDate expiryDate;


	public ExpiringItem(String description, LocalDate expiryDate) {
		this.description = description;
		this.expiryDate = expiryDate;
	}

	public String getDescription() {
		return description;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	public String getFormattedExpiryDate() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLL-DD-YYYY");
		String formattedDate = expiryDate.format(formatter);
		return formattedDate;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof ExpiringItem) {
			ExpiringItem otherExpiringItem = (ExpiringItem) otherObj;
			
			String otherDescription = otherExpiringItem.description;
			LocalDate otherExpiryDate = otherExpiringItem.expiryDate;
			
			if (description.equalsIgnoreCase(otherDescription) &&
					expiryDate.equals(otherExpiryDate)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(ExpiringItem other) {
			return expiryDate.compareTo(other.expiryDate);
	}
	
	@Override
	public String toString() {
		String s = description + " expires on " + expiryDate;
		return s;
	}
	

}
