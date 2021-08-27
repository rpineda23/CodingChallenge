// Ricardo Pineda Week 1 PO

import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your credit card number...");
		Long n = scan.nextLong();
		boolean valid = validate(n);
		if(valid)
			System.out.println("Credit Card Number is Valid :)");
		else 
			System.out.println("Credit Card Number is Invalid :(");
		scan.close();
	}
	
	public static boolean validate(long num){

        String credNum = Long.toString(num);
        if (credNum.length() < 14 || credNum.length() > 19 || credNum.matches("\\D")) {
            return false;
        }

        int lastDigit = Character.getNumericValue(credNum.charAt(credNum.length() - 1));
        int finalSum = 0;

        for (int i = credNum.length() - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                int newNum = Character.getNumericValue(credNum.charAt(i)) * 2;
                if (newNum > 9) {
                    newNum = (newNum / 10) + (newNum % 10);
                }
                System.out.println(newNum);
                finalSum += newNum;
            } else {
                finalSum += Character.getNumericValue(credNum.charAt(i));
            }
        }


        int fromTen = 10 - (finalSum % 10);
        return fromTen == lastDigit;
    }
}