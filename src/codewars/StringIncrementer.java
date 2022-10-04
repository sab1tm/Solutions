package codewars;

// Your job is to write a function which increments a string, to create a new string.
// If the string already ends with a number, the number should be incremented by 1.
// If the string does not end with a number. the number 1 should be appended to the new string.
// Examples:
// foo -> foo1
// foobar23 -> foobar24
// foo0042 -> foo0043
// foo9 -> foo10
// foo099 -> foo100
// Attention: If the number has leading zeros the amount of digits should be considered.

import java.math.BigInteger;

public class StringIncrementer {

    public static void main(String[] args) {
        String input = "foobar0099";

        String result = incrementString(input);

        System.out.println(result);
    }

    public static String incrementString(String str) {
        String u = java.util.regex.Pattern.compile("(\\d+)$").matcher(str).replaceAll(x -> String.format("%0" + x.group().length() +"d", new BigInteger(x.group()).add(BigInteger.ONE)));
        return u.matches(".*(?<!\\d)")?u+1:u;
    }

}
