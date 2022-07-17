package leetcode17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) return res;
        backtracking(res, digits, 0, new StringBuilder(), map);
        return res;
    }

    private void backtracking(List<String> res, String digits, int idx, StringBuilder sb, Map<Character, String> map) {
        int n = digits.length();
        if (idx == n) {
            res.add(new String(sb));
            return;
        }
        char c = digits.charAt(idx);
        String level = map.get(c);
        for (int i = 0; i < level.length(); i++) { // 从0起，每次从level中拿出一个加入sb后permute，之后再删除这个，下一轮循环拿取下一个
            sb.append(level.charAt(i)); // 剪枝，直接在添加过程中进行permutation，就不需要单独拉扯出来进行permutation了
            backtracking(res, digits, idx + 1, sb, map);
            sb.deleteCharAt(idx);
        }
    }
}