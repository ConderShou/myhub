//*********************************
// Conder Shou
// cs3544
// Zipcode.java
//
// Converts bars into their ZIP code, reporting errors for
// their input format or for a mismatch of digits
//*********************************


public class Zipcode{

	private String zipcode;
	private String barcode;
	private boolean continueBarLoop;	// used as an error check for the barcode conversion

	public Zipcode(int zip_number){

		zipcode = Integer.toString(zip_number); // converting int to String

		checkZip();
	}

	public Zipcode(String bar_code) {

		barcode = bar_code;
		checkBar();
	}


	public void convertZipCode (String zipcode) {

		String digitBar = "|";
		int sum = 0;
		int checkDigit = 0;
		int digit = 0;

		// Selecting one digit at a time to convert
		for (int i = 0; i <= zipcode.length() - 1; i++) {

			if (i <= zipcode.length() - 2) {
				// Extracting one digit
				digit = Integer.parseInt(zipcode.substring(i, i+1)); 
			} else if (i == zipcode.length() - 1) {
				digit = Integer.parseInt(zipcode.substring(i)); 
			}

			// Computing the sum by adding each digit of the zipcode as it is made into an integer again
			sum = sum + digit;

			// Converting digit and adding it to the total string
			digitBar = digitBar.concat(matchDigit(digit));
		}


		while (sum % 10 != 0){	// Checking to make sure the number is a multiple of 10
			checkDigit++;		// Keeping track of check digit
			sum++;
		} 

		if (checkDigit != 0) {
			digitBar = digitBar.concat(matchDigit(checkDigit)).concat("|");
		} else if (checkDigit == 0){
			digitBar = digitBar.concat("|");
		}

		barcode = digitBar;
	}

	public void convertBarcode (String barcode) {

		String zipString = "";
		zipcode = "";
		int sum = 0;
		int digit;
		/* The initialization of i to 1 allows us to ignore the extra full bar in the front
		 *
		 * The limit of i to less than equal the barcode length - 7 allows us to ignore
		 *   the check digit and the extra full bar at the end of the barcode
		 */
		continueBarLoop = true;

		if (barcode.length() == 32) {
			for (int i = 1; i < barcode.length() - 10; i+=5) {	
				// increments by 5 because each bar symbol has 5 bars	

				if (continueBarLoop) {
					zipString = barcode.substring(i, i+5);	// end of substring is at i + 6 because it's exclusive
					zipString = matchBars(zipString); 

					if (zipString != null) {
						zipcode = zipcode.concat(zipString);

						digit = Integer.parseInt(zipString);
						sum = sum + digit;
					}

				}
			}

		} else if (barcode.length() == 27) {
			for (int i = 1; i < barcode.length() - 5; i+=5) {	// NOTICE that the limit of i is different for a smaller stirng
				//    accounting for a barcode that didnt need a check digit
				// increments by 5 because each bar symbol has 5 bars	

				if (continueBarLoop) {
					zipString = barcode.substring(i, i+5);	// end of substring is at i + 6 because it's exclusive
					zipString = matchBars(zipString); 

					if (zipString != null) {
						zipcode = zipcode.concat(zipString);

						digit = Integer.parseInt(zipString);
						sum = sum + digit;
					}
				}
			}
		}


	}




public String matchDigit (int digit) {

	String bar;

	// matching each digit of the zipcode to the correpsonding bar symbol
	switch (digit) {
	case 1: bar = ":::||"; break;
	case 2: bar = "::|:|"; break;
	case 3: bar = "::||:"; break;
	case 4: bar = ":|::|"; break;
	case 5: bar = ":|:|:"; break;
	case 6: bar = ":||::"; break;
	case 7: bar = "|:::|"; break;
	case 8: bar = "|::|:"; break;
	case 9: bar = "|:|::"; break;
	case 0: bar = "||:::"; break;
	default: bar = ""; break;
	}

	return bar;

}

public String matchBars (String barSegment) {

	if (barSegment.equals(":::||")) {
		barSegment = "1";
	} else if (barSegment.equals("::|:|")) {
		barSegment = "2"; 
	} else if (barSegment.equals("::||:")) {
		barSegment = "3"; 
	} else if (barSegment.equals(":|::|")) {
		barSegment = "4"; 
	} else if (barSegment.equals(":|:|:")) {
		barSegment = "5";
	} else if (barSegment.equals(":||::")) {
		barSegment = "6";  
	} else if (barSegment.equals("|:::|")) {
		barSegment = "7";  
	} else if (barSegment.equals("|::|:")) {
		barSegment = "8";  
	} else if (barSegment.equals("|:|::")) {
		barSegment = "9"; 
	} else if (barSegment.equals("||:::")) {
		barSegment = "0";  
	} else {
		System.out.println();
		System.out.println("--------Invalid Input--------");
		System.out.println();	

		continueBarLoop = false;
		zipcode = null;
		return null;
	}
	return barSegment;

}

public void checkZip() {

	/* If the size of the zipcode is less than 5 digits, it is invalid.
	 * If there's a zero in the beginning, then the zip code is considered too small,
	 * 		and it is considered invalid too 
	 */

	if (zipcode.length() != 5) {	
		System.out.println();
		System.out.println("--------Invalid Input--------");
		System.out.println();	

		/* By not invoking convertCode at all, and not assigning a value to barcode
		 *    barcode is inherently "null"	
		 */

	} else {

		convertZipCode(zipcode);


	}
}

public void checkBar() {

	if (barcode.length() != 32 && barcode.length() != 27) {		// in total, there should be 32 elements in the string array
		System.out.println();									//    or 27, if there is no check digit
		System.out.println("--------Invalid Input--------");
		System.out.println();

		return;
	} else {
		convertBarcode(barcode);
	}
}


public String getBarcode(){
	//this method was left as it was
	return barcode;
}

public String getZipcode() {

	return zipcode;
}
}


