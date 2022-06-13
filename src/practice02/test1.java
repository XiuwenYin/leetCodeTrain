package practice02;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.substring(1, s.length());
//        System.out.println(s);
        String[] arr = s.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String x : arr) {
//            System.out.println(x);
            if (x.equals(".")) continue;
            if (x.equals("") || x.equals("...")) {
                System.out.println("/");
                return;
            }
            if (x.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                } else {
                    System.out.println("/");
                    return;
                }
            } else {
                deque.add(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(String.join("/", deque));
        String res = sb.toString();
        System.out.println(res);
    }
}
