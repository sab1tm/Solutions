package CodeWars;

// Complete the solution so that the function will break up camel casing, using a space between words.
// Example
// "camelCasing"  =>  "camel Casing"
// "identifier"   =>  "identifier"
// ""             =>  ""

public class BreakCamelCase {

    public static void main(String[] args) {
        String input = "camelCasing";

        String result = camelCase(input);

        System.out.println(result);
    }

    public static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
}
