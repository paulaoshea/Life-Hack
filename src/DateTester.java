
public class DateTester {

	public static void main(String[] args) {
		
		MothersDayUK mothersDayUK = new MothersDayUK(2021);
		
		System.out.println("and mothers day in 2021 is : " + mothersDayUK);
		
		mothersDayUK.setYear(2022);
		
		System.out.println("and mothers day in 2022 is : " + mothersDayUK);

		mothersDayUK.setYear(2023);
		
		System.out.println("and mothers day in 2023 is : " + mothersDayUK);
		
		MothersDayUK mothersDayUK2 = new MothersDayUK(2023);
		MothersDayUK mothersDayUK3 = new MothersDayUK(2025);
		
		System.out.println("\n + mothersDayUK2 = " + mothersDayUK2);
		System.out.println("\n + mothersDayUK = " + mothersDayUK);

		
		System.out.println("should be true = " + mothersDayUK2.equals(mothersDayUK));
		System.out.println("should be false = " + mothersDayUK3.equals(mothersDayUK));
		
		MothersDayUSA americanMothersDay = new MothersDayUSA(2021);
		System.out.println("and mothers day USA in 2021 is : " + americanMothersDay);
		americanMothersDay.setYear(2022);
		System.out.println("and mothers day USA in 2022 is : " + americanMothersDay);
		
		FathersDay americanFathers = new FathersDay(2021);
		System.out.println("and fathers day USA in 2021 is : " + americanFathers);
		americanFathers.setYear(2022);
		System.out.println("and fathers day USA in 2022 is : " + americanFathers);
	}

}
