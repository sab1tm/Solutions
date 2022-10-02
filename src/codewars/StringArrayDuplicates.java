package codewars;

import java.util.Arrays;

public class StringArrayDuplicates {

    public static void main(String[] args) {
        String[] input = {"abracadabra","allottee","assessee"};

        String[] result = dup(input);

        System.out.println(Arrays.toString(result));
    }

    public static String[] dup(String[] arr){
        return Arrays.stream(arr)
                .map(s -> s.replaceAll("(\\w)\\1{1,}", "$1"))
                .toArray(String[]::new);
    }
}
