package codewars;

import java.util.Arrays;
import java.util.Comparator;

public class SumOfIntervals {

    public static void main(String[] args) {

        int[][] input = new int[][]{{5, 8}, {3, 6}, {1, 2}};

        int result = sumIntervals(input);

        System.out.println(result);

    }

    public static int sumIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        if (intervals.length == 1)
            return intervals[0][1] - intervals[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(intervals));

        int result = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (max >= intervals[i][0]) {
                if (intervals[i][1] > max)
                    max = intervals[i][1];
            } else {
                result += max - min;
                min = intervals[i][0];
                max = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                result += max - min;
            }
        }

        return result;
    }
}
