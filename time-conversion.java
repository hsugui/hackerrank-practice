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

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String timeArray[] = s.split(":");
        String AmPm = timeArray[2].substring(2, 4);

        int hh = Integer.parseInt(timeArray[0]);
        int mm = Integer.parseInt(timeArray[1]);
        int ss = Integer.parseInt(timeArray[2].substring(0,2));

        int h = hh;
        
        if (AmPm.equals("AM") && hh == 12) {
            h=0;
        } else if (AmPm.equals("PM") && hh < 12) {
            h += 12;
        }
        
        return String.format("%02d:%02d:%02d", h, mm, ss);
    }
}

public class Solution {
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