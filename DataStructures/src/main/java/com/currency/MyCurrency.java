package com.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class MyCurrency {

	public static void main(String[] args) {
		
		double amt = 12324.137;
		
		NumberFormat nf_US = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf_US.format(amt));
		
		NumberFormat nf_China = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println(nf_China.format(amt));
		
		NumberFormat nf_France = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println(nf_France.format(amt));
		
		// India does not has Locale so we need to construct one and pass it
		NumberFormat nf_India = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		System.out.println(nf_India.format(amt));

	}

}
