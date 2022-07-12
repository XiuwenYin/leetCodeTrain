package jvmgo.book.ch05;

public class Test {
    public static void main(String[] args) {
        String a = "this is a cat";
        char[] arr = a.toCharArray();
        if (!Character.isUpperCase(arr[0])) arr[0] = Character.toUpperCase(arr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        System.out.println(sb.toString());



    }
}
