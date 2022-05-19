package com.assignment2.utility;

import java.util.Random;

public class GeneratePassword {
	private static Random random=new Random();
	
	public static String getTempPass() {
		return String.valueOf(random.nextInt(999999));
	}
}
