package codewars;

public class SumStringsAsNumbers {

    public static void main(String[] args) {

        String inputA = "1";
        String inputB = "9999";

        String result = sumStrings(inputA, inputB);

        System.out.println(result);
    }

    public static String sumStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());

        int i = 0;
        int d0 = 0; int d1 = 0; int d2 = 0; int s;

        while (++i <= maxLength) {
            if (i <= a.length()) {
                d1 = Character.getNumericValue(a.charAt(a.length() - i));
            } else d1 = 0;
            if (i <= b.length()) {
                d2 = Character.getNumericValue(b.charAt(b.length() - i));
            } else d2 = 0;
            s = d1 + d2 + d0;
            d0 = 0;
            if (s > 9) {
                d0 = 1;
                s -= 10;
            }
            result.append(s);
        }
        if (d0 == 1)
            result.append(1);

        return result.reverse().toString();
    }

}
