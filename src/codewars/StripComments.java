package codewars;

// Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
// Any whitespace at the end of the line should also be stripped out.
// Example:
// Given an input string of:
// apples, pears # and bananas
// grapes
// bananas !apples
// The output expected would be:
// apples, pears
// grapes
// bananas
// The code would be called like so:
// var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"

public class StripComments {

    public static void main(String[] args) {
        String input = "apples, pears # and bananas\ngrapes\nbananas !apples";
        String[] endSymbols = new String[]{"#", "!"};

        String result = stripComments(input, endSymbols);

        System.out.println(result);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (String commentSymbol : commentSymbols) {
                int position = lines[i].indexOf(commentSymbol);
                if (position > -1) {
                    lines[i] = lines[i].substring(0, position);
                }
                lines[i] = lines[i].stripTrailing();
            }
        }
        return String.join("\n", lines);
    }
}
