import java.util.*;

public class Aflevering1_Sem1 {
	public static void main(String[] args) {
		// romanNumerals();
		// palindrome();
		// buffonsNeedle();
	}
	
	public static void romanNumerals() {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter positive integer to convert: ");
		if(console.hasNextInt()) {
			int normalNumber = console.nextInt();
			String romanNumber = createRomanNumeral(normalNumber);
			System.out.println(normalNumber + " = " + romanNumber);
		} else {
			System.out.println("NOT A NUMBER");
		}
	}
	
    
    public static String createRomanNumeral(int number) {
        String output = "";
        output += convertThousandsToRomanNumber((number/1000));
        output += convertSingleNumberToRomanNumber((number%1000) / 100, 3);
        output += convertSingleNumberToRomanNumber((number%100) / 10, 2);
        output += convertSingleNumberToRomanNumber(number%10, 1);
        return output;
    }
    
    public static String convertSingleNumberToRomanNumber(int number, int factor) {
        String romanString = "";
        if(number == 0) {
            return "";
        } else if(number == 1) {
            romanString = "I";
        } else if(number == 2) {
            romanString = "II";
        } else if(number == 3) {
            romanString = "III";
        } else if(number == 4) {
            romanString = "IV";
        } else if(number == 5) {
            romanString = "V";
        } else if(number == 6) {
            romanString = "VI";
        } else if(number == 7) {
            romanString = "VII";
        } else if(number == 8) {
            romanString = "VIII";
        } else {
            romanString = "IX";
        }
        
        if(factor == 2) {
            romanString = romanString.replace("X", "C").replace("V", "L").replace("I", "X");
        } else if(factor == 3) {
            romanString = romanString.replace("X", "M").replace("V", "D").replace("I", "C");
        }
        
        
        return romanString;
    }
    
    public static String convertThousandsToRomanNumber(int thousands) {
        String s = "";
        for(int i = 0; i < thousands; i++) {
            s += "M";
        }
        return s;
    }
    
    
    // =========================================================================
	
	public static void palindrome() {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter line to check: ");
		String sentence = console.nextLine();
		System.out.println("\"" + sentence + "\" is " + (is_string_palindrome(sentence) ? "" : "not ") + "a palindrome!");
	}
	
	public static boolean is_string_palindrome(String input) {
		String stringNoLetters = removeAllNonLetters(input).toLowerCase();
		for(int i = 0; i < stringNoLetters.length() / 2; i++) {
			char letter = stringNoLetters.charAt(i);
			char matchedLetter = stringNoLetters.charAt(stringNoLetters.length() - i - 1);
			if(letter != matchedLetter) {
				return false;
			}
		}
		return true;
	}
	
	public static String removeAllNonLetters(String stringInput) {
		String newString = "";
		for(int i = 0; i < stringInput.length(); i++) {
			if(is_letter(stringInput.charAt(i))) {
				newString += stringInput.charAt(i);
			}
		}
		return newString;
	}
	
	public static boolean is_letter(char letter) {
		return (Character.toUpperCase(letter) != Character.toLowerCase(letter));
	}
	
	
	// =========================================================================
	
	
	public static void buffonsNeedle() {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter number of iterations: ");
		if(console.hasNextInt()) {
			int loop = console.nextInt();
			int hits = throwBuffonsNeedle(loop);
			System.out.println( loop + " / " + hits + " = " + ((double)loop / hits));
		} else {
			System.out.println("Please provide a positive integer");
		}
	}
	
	public static int throwBuffonsNeedle(int loops) {
		Random rnd = new Random();
		int amountHit = 0;
		for(int i = 0; i < loops; i++) {
			Double needle_start = rnd.nextDouble()*2;
			Double needle_angle = rnd.nextDouble() * Math.PI;
			Double needle_end   = Math.sin(needle_angle) + needle_start;
			if(needle_end >=  2) {
				amountHit++;
			}
		}
		return amountHit;
	}
	
}
