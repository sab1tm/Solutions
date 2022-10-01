package CodeWars;

// Pirates have notorious difficulty with enunciating. They tend to blur all the letters together and scream at people.
// At long last, we need a way to unscramble what these pirates are saying.
// Write a function that will accept a jumble of letters as well as a dictionary, and output a list of words that the pirate might have meant.
// For example:
// grabscrab( "ortsp", ["sport", "parrot", "ports", "matey"] )
// Should return ["sport", "ports"].
// Return matches in the same order as in the dictionary. Return an empty array if there are no matches.
// Good luck!

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PirateWords {

    public static void main(String[] args) {
        String input = "ortsp";
        List<String> words = List.of("sport", "parrot", "ports", "matey");

        List<String> result = grabscrab(input, words);

        System.out.println(result);
    }

    public static List<String> grabscrab(String s, List<String> words) {
        String sortedChars = sort(s);
        return words.stream().filter(word -> sortedChars.equals(sort(word))).collect(Collectors.toList());
    }

    private static String sort(String unsorted) {
        char[] chars = unsorted.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

