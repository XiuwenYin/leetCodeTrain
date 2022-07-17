package jvmgo.book.ch05;

public class Test {
    public static void main(String[] args) {
        String a = "this is a cat";
        char[] arr = a.toCharArray();
        if (!Character.isUpperCase(arr[0])) arr[0] = Character.toUpperCase(arr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        System.out.println(sb.toString());

        char c = 'a';
        c += 1;
        System.out.println(c);

        /* 面向对象5大（7大）原则
         * 单一职责 single responsibility
         * 开闭 open closed
         * 李氏替换 liskov substitution
         * 接口隔离 interface segregation
         * 依赖翻转 dependency inversion
         * 迪米特 law of demeter
         * 组合/聚合复用 composite/aggregate reuse
         */

    }
}
