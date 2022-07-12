package hackerRank.Plus_Minus;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Plus_Minus {
}

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int pos = 0, neg = 0, zero = 0;
        int n = arr.size();
        for (int x : arr) {
            if (x > 0) pos++;
            else if (x < 0) neg++;
            else zero++;
        }
        double posRes = (double)pos / n;
        double negRes = (double)neg / n;
        double zeroRes = (double)zero / n;
        System.out.printf("%.6f", posRes);
        System.out.println();
        System.out.printf("%.6f", negRes);
        System.out.println();
        System.out.printf("%.6f", zeroRes);
        System.out.println();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}