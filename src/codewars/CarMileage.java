package codewars;

// https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
// It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input,
// and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.
// "Interesting" Numbers
// Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
// Any digit followed by all zeros: 100, 90000
// Every digit is the same number: 1111
// The digits are sequential, incrementing: 1234
// The digits are sequential, decrementing: 4321
// The digits are a palindrome: 1221 or 73837
// The digits match one of the values in the awesomePhrases array
// † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
// ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

import java.util.Arrays;

public class CarMileage {

    public static void main(String[] args) {
        int number = 100;
        int[] awesomePhrases = {101};

        int result = isInteresting(number, awesomePhrases);

        System.out.println(result);
    }

    public static int isInteresting(int number, int[] awesomePhrases) {

        // awesome phrases check
        if (Arrays.stream(awesomePhrases).anyMatch(n -> n == number))
            return 2;

        // interesting number check
        // regex?

        // interesting number occurs within the next two miles
        // regex?

        return 0;
    }

}
