package codewars;

// Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
// It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.
// Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero.
// In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII.
// 1666 uses each Roman symbol in descending order: MDCLXVI.
// Input range : 1 <= n < 4000
// In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").
// Examples
// RomanNumerals.toRoman(1000) // should return 'M'
// RomanNumerals.fromRoman("M") // should return 1000
// Help
//   Symbol	    Value
//   I	        1
//   IV	        4
//   V	        5
//   X	        10
//   L	        50
//   C	        100
//   D	        500
//   M	        1000

public class RomanNumeralsHelper {

    private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        // 4 -> IV
        // 2292 -> MM CC XC II
        // 2799 -> MM DCC XC IX
        // 1990 -> M CM XC
        // 2411 -> MM CD X I

        int input = 2799;

        String result = toRoman(input);
        int testResult = fromRoman(result);

        System.out.println(result);
        System.out.println(testResult);
    }

    public static String toRoman(int n) {
        String roman = "";

        for (int i = 0; i < numbers.length; i++) {
            while (n >= numbers[i]) {
                roman += letters[i];
                n -= numbers[i];
            }
        }
        return roman;
    }

    public static int fromRoman(String romanNumeral) {
        int i = 0;
        int arabic = 0;

        while (i < romanNumeral.length()) {
            char letter = romanNumeral.charAt(i);
            int number = letterToNumber(letter);
            i++;
            if (i == romanNumeral.length()) {
                arabic += number;
            } else {
                int nextNumber = letterToNumber(romanNumeral.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                } else {
                    arabic += number;
                }
            }

        }
        return arabic;
    }

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new NumberFormatException(
                        "Illegal character " + letter);
        }
    }
}
