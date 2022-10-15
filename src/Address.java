public class Address {

	private String number, street, street2, city, state, zip1, country;
	
	private Address(AddressBuilder builder) {
		this.number = builder.number;
		this.street = builder.street;
		this.street2 = builder.street2;
		this.city = builder.city;
		this.state = builder.state;
		this.zip1 = builder.zip1;
		this.country = builder.country;
		
	}
	
	public String getNumber() {
		return number;
	}
	public String getStreet1() {
		return street;
	}
	public String getStreet2() {
		return street2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip1() {
		return zip1;
	}
	public String geCountry() {
		return country;
	}
	@Override
	public String toString() {
		String s = number + " " + street + ", ";
		if (!street2.equals("")) {
			s += street2 + ", ";
		}
		if (!city.equals("")) {
			s += city + ", ";
		}
		if (!state.equals("")) {
			s += state + ", ";
		}
		s += zip1 + ", " + country;
		
		return s;
	}
	
	public static class AddressBuilder {
		private String number, street, zip1;
		private String street2 = "", city = "", state = "", country = "";
		
		public AddressBuilder(String number, String street, String zip1) {
			this.number = number;
			this.street = street;
			this.zip1 = zip1;
		} 
		public AddressBuilder() {
			
		}
		public AddressBuilder number(String var) {
			this.number = var;
			return this;
		}
		public AddressBuilder street(String var) {
			this.street = var;
			return this;
		}
		public AddressBuilder zip1(String var) {
			this.zip1 = var;
			return this;
		}	
		public AddressBuilder street2(String var) {
			this.street2 = var;
			return this;
		}
		public AddressBuilder city(String var) {
			this.city = var;
			return this;
		}
		public AddressBuilder state(String var) {
			this.state = var;
			return this;
		}
		public AddressBuilder country(String var) {
			this.country = var;
			return this;
		}
		public Address build() {
			Address address = new Address(this);
			
			if(number==null || street == null || zip1==null) {
				throw new IllegalStateException();
			}
			
			return address;
		}
		
		
	}
}
