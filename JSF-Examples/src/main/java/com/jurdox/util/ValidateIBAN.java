package com.jurdox.util;

public class ValidateIBAN {
	static StringBuilder sbMod = new StringBuilder();

	public static boolean validate(String iban) {

		if (iban.length() != 24) {
			return false;
		}

		String firstChars = iban.substring(0, 4);
		System.out.println(firstChars);

		String beforeMod = iban.substring(4).concat(firstChars);
		System.out.println(beforeMod);
		System.out.println();

		// create digit IBAN
		for (int i = 0; i < iban.length(); i++) {
			char s = beforeMod.charAt(i);
			if (!Character.isDigit(s)) {
				System.out.println(s);
				int j = Character.getNumericValue(s);
				System.out.println(j);
				sbMod.append(j);
			} else {
				sbMod.append(s);
			}
		}

		System.out.println("Digit IBAN: " + sbMod.toString());

		// vypocet

		int mod1 = Integer.parseInt(sbMod.substring(0, 9));
		System.out.println(mod1);
		int result1 = mod1 % 97;
		System.out.println(result1);

		String res1 = String.valueOf(result1);
		res1 = res1.concat(sbMod.substring(9, 16));
		System.out.println(res1);

		int mod2 = Integer.parseInt(res1);
		int result2 = mod2 % 97;
		System.out.println(result2);

		String res2 = String.valueOf(result2);
		res2 = res2.concat(sbMod.substring(16, 23));
		System.out.println(res2);

		int mod3 = Integer.parseInt(res2);
		int result3 = mod3 % 97;
		System.out.println(result3);

		String res3 = String.valueOf(result3);
		res3 = res3.concat(sbMod.substring(23, sbMod.length()));
		System.out.println(res3);

		int mod4 = Integer.parseInt(res3);
		int result4 = mod4 % 97;
		System.out.println(result4);

		if (result4 == 1) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// validate("SK3375000000000008700837");
		System.out.println("Is valid? \n"
				+ validate("SK3375000000000008700837"));
	}
}
