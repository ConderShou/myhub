//*********************************
//
// Zip code class
//
// This is a test class for your zip code class.
// Your Zipcode class must work with this test class.
// Do not alter this class.
//
//*********************************

import java.util.Scanner;

public class ZipTest{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a ZIP code: ");
        int zip = input.nextInt();
        Zipcode code = new Zipcode(zip);
	System.out.println("The bar code: ");
        System.out.println(code.getBarcode());
    }
}
    

