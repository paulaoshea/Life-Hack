

import java.time.MonthDay;

public class Contact implements Comparable<Contact> {
	
	private String firstName;
	private String secondName;
	private Address address;
	private MonthDay birthday;
	private String phoneNumber;
	private String email;


	public Contact(String firstName, String secondName, Address address, MonthDay birthday,
					String phoneNumber, String email) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getsecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address ) {
		this.address = address;
	}
	
	public MonthDay getbirthday() {
		return birthday;
	}
	
	public String getFormattedBirthday() {
		
		int extractedMonth = birthday.getMonthValue();
		int extractedDay = birthday.getDayOfMonth();
			
		String monthStrLeadingZero = extractedMonth < 10 ? "0" + extractedMonth : String.valueOf(extractedMonth);
		String dayStrLeadingZero = extractedDay < 10 ? "0" + extractedDay : String.valueOf(extractedDay);
		
		return monthStrLeadingZero + "-" + dayStrLeadingZero;
	}
	
	public void setbirthday(MonthDay birthday) {
		this.birthday = birthday;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof Contact) {
			Contact otherContact = (Contact) otherObj;
			
			String otherFirstName = otherContact.firstName;
			String otherSecondName = otherContact.secondName;
			MonthDay otherBirthday = otherContact.birthday;
			
			if (firstName.equalsIgnoreCase(otherFirstName) &&
					otherSecondName.equalsIgnoreCase(otherSecondName) &&
					birthday.equals(otherBirthday)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Contact other) {
		if (secondName.compareToIgnoreCase(other.secondName) != 0) {
			return secondName.compareToIgnoreCase(other.secondName);
		} else if (firstName.compareToIgnoreCase(other.firstName) != 0) {
			return firstName.compareToIgnoreCase(other.firstName);
		} else {
			return birthday.compareTo(other.birthday);
		}
	}
	
	@Override
	public String toString() {
		String s = firstName + " " + secondName;
		s += " with address: " + address;
		s += " with a birthday: " + birthday;
		s += " tel: " + phoneNumber;
		s += " email: " + email;
		return s;
	}
	

}
