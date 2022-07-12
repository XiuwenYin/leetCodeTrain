package hackerRank.Time_Conversion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Time_Conversion {

}

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        int n = s.length();
        String sub = s.substring(n - 2);
        StringBuilder sb = new StringBuilder(s.substring(2, 8));
        StringBuilder time = new StringBuilder(s.substring(0, 2));
        if (sub.equals("PM")) {
            int timeCon = Integer.parseInt(time.toString());
            if (timeCon != 12) {
                timeCon += 12;
            }
            time = new StringBuilder(String.valueOf(timeCon));
        } else {
            int timeCon = Integer.parseInt(time.toString());
            if (timeCon == 12) {
                time = new StringBuilder("00");
            }
        }
        time.append(sb);
        return time.toString();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}