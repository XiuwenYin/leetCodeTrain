package practice02;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] arr = new String[n];
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = scan.nextLine();
            arr[i] = temp;
        }
        if (arr.length == 0) {
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String cur = arr[i];
            String temp = cur.substring(0, 3);
            System.out.println(temp);
            if (temp.equals("tel:")) {
                tel(cur, sb);
            } else if (temp.equals("sip:")) {
                sip(cur, sb);
            } else {
                sb.append("0 ");
            }
        }
        String res = sb.substring(0, sb.length() - 1).toString();
        System.out.println(res);
    }

    public static void tel(String cur, StringBuilder sb) {
        if (cur.charAt(4) != '+') {
            sb.append("0 ");
            return;
        }
        String.format("\u002d", cur);

        String subCur = cur.substring(4, cur.length());
        if (subCur.length() != 13 || subCur.length() != 14) {
            sb.append("0 ");
            return;
        }
        for (int i = 0; i < subCur.length(); i++) {
            char c = subCur.charAt(i);
            if (c < '0' || c > '9' || c != '-') {
                sb.append("0 ");
                return;
            }
        }
        sb.append("1 ");
        return;
    }

    public static void sip(String cur, StringBuilder sb) {
        Map<Character, Integer> hashMap = new HashMap<>();
        String subCur = cur.substring(3, cur.length());
        for (int i = 0; i < subCur.length(); i++) {
            char c = subCur.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getKey() == '@') {
                if (hashMap.get('@') != 1) {
                    sb.append("0 ");
                    return;
                }
            }
        }
        sb.append("1 ");
        return;
    }
}