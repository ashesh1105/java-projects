package com.algorithms.string;

public class MatchingSymbol {

	/*
	 * Is there anyway this algo can be improved from O(mn)?
	 * 
	 * Chemicals array: ['Amazon', 'Microsoft', 'Google']
	 * 
	 * Symbols: ['I', 'Am', 'cro', 'Na', 'le', 'abc']
	 * 
	 * Output: [ Amazon [Am], Microsoft [cro], Google [le] ] 
	 * 
	 * If the chemical string matches more than one symbol, then choose the one with
	 * longest length. (ex. 'Microsoft' matches 'i' and 'cro')
	 */

	public static void main(String[] args) {
		
		String [] str = {"Amazon", "Microsoft", "Google"};
		String [] sym = {"I", "Am", "cro", "Na", "le", "abc"};
		
		String [] result = new MatchingSymbol().matchStringWithSymbols(str, sym);
		
		for (String stringWithSymbol : result) {
			System.out.print(stringWithSymbol + " ");
		}

	}

	private String[] matchStringWithSymbols(String[] str, String[] sym) {
		
		// Null check
		if (str == null || sym == null ) {
			System.out.println("Either string or symbols array passed are null.");
			return str;
		}
		
		int lenStr = str.length;
		int lenSym = sym.length;
		
		// Empty array check
		if (lenStr == 0 || lenSym == 0) {
			System.out.println("Either string or symbols array passed empty.");
			return str;
		}
		
		// result array that will contain strings with largest matching symbol
		String [] result = new String[lenStr];
		
		for (int i=0; i<lenStr; i++) {
			
			// We want to associate symbol (substrong match) which is largest in length so define variables to capture that
			int maxLenSym = 0;
			int indexMaxLenSymbol = 0;
			
			// Iterate through symbols array to find the best match
			for (int j=0; j<lenSym; j++) {
				
				String symbol = sym[j];
				
				if (str[i].indexOf(symbol) != -1) {
					
					int temp = symbol.length();
					
					if (temp > maxLenSym) {
						maxLenSym = temp;
						indexMaxLenSymbol = j;
					}
				}
			}
			
			// Populate result array by associating strings with best matching symbol 
			result[i] = str[i] + " [" + sym[indexMaxLenSymbol] + "]";
		}
		
		return result;
	}

}
