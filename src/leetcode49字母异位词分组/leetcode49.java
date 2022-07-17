package leetcode49字母异位词分组;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 流1
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams01(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }

    /**
     * 流2
     *
     */
    public List<List<String>> groupAnagrams02(String[] strs) {
        // str -> intstream -> sort -> collect by StringBuilder
        return new ArrayList<>(Arrays.stream(strs).collect(
                Collectors.groupingBy(str ->
                str.chars().sorted().collect(
                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                ).toString())).values());
    }

    /**
     * 哈希表 + 排序
     * 用这个
     */
    public List<List<String>> groupAnagrams03(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // 将每次sort过后的str当做key，val就是存储sort前的str
        for (String s : strs) {
            char[] arr = s.toCharArray(); // 换成char[]用于排序
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> level = map.getOrDefault(key, new ArrayList<>());
            level.add(s);
            map.put(key, level);
        }
        return new ArrayList<>(map.values());
    }
}


