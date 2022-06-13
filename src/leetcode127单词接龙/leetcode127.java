package leetcode127单词接龙;

import java.util.*;

public class leetcode127 {
    /**
     * 图
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        Map<String, List<String>> graph = constructGraph(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(beginWord);
        queue.add(beginWord);

        int cost = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return cost;
                }
                for (String neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            cost++;
        }
        return 0;
    }

    private Map<String, List<String>> constructGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String w1 = wordList.get(i), w2 = wordList.get(j);
                if (oneChangeAway(w1, w2)) {
                    graph.computeIfAbsent(w1, k -> new ArrayList<>()).add(w2);
                    graph.computeIfAbsent(w2, k -> new ArrayList<>()).add(w1);
                }
            }
        }
        return graph;
    }

    private boolean oneChangeAway(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            char c1 = w1.charAt(i), c2 = w2.charAt(i);
            if (c1 != c2) diff++;
        }
        return diff == 1;
    }

    /**
     * 普通 bfs
     */
    public int ladderLength01(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>(wordList); // 将wordList放入哈希集合中，用于去重
        Queue<String> queue = new LinkedList<>(); // bfs模板
        queue.offer(beginWord); // 将起始单词放入queue
        int n = beginWord.length();
        int step = 1; // 初始化次数（答案）
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step; // 如果此时cur 等于结束单词，那么结束循环
                for (int j = 0; j < n; j++) { // 循环当前单词进行每一位替换
                    for (char c = 'a'; c <= 'z'; c++) { // 对从 a - z 进行替换
                        StringBuilder next = new StringBuilder(cur); // 将cur用 StringBuilder重构
                        next.setCharAt(j, c); // 替换next（也就是cur）中 j位置的字母，用 c来替代
                        String nextWord = next.toString();
                        if (hashSet.contains(nextWord)) { // 每次替换完之后都和 hashSet对比，看是否存在
                            if (nextWord.equals(endWord)) return step + 1; // 如果是，则直接返回步数 + 1
                            hashSet.remove(nextWord); // 如果不是，每次记得要从哈希集合中拿掉匹配过的单词，因为每个单词仅用一次
                            queue.offer(nextWord); // 并且要把nextWord放入queue中
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 双向bfs
     * 目前最优解
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength02(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();  // 双向bfs其中一个集合
        Set<String> endSet = new HashSet<>();  // 双向bfs其中一个集合
        Set<String> wordListSet = new HashSet<>(wordList); // 将wordList放入哈希集合中，用于去重
        Set<String> visited = new HashSet<>();

        if (!wordListSet.contains(endWord)) return 0;
        int n = beginWord.length();
        int step = 1;
        beginSet.add(beginWord); // 先将起始单词放入beginSet
        endSet.add(endWord); // 将结束单词放入endSet

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) { // 先从beginSet开始，看看是否能reach到endSet；这一步相当于用queue的bfs的poll();
                char[] chars = word.toCharArray(); // 对于当前遍历到的单词，将其转化成为charArray
                for (int i = 0; i < n; i++) { // 对于这个charArray进行每一位遍历
                    for (char c = 'a'; c <= 'z'; c++) { // 对每一位进行26个字母的替换
                        char pre = chars[i]; // 记录原本这个位置上的字母
                        chars[i] = c; // 替换
                        String nextWord = new String(chars); // 将数组恢复成字符串

                        // 检查这个字符串是不是存在于endSet（因为endSet中有很多单词），碰到就代表上下接触到了，直接返回 step+1
                        if (endSet.contains(nextWord)) return step + 1;
                        // 看看当前单词是否经历过了（没有就加入有的话此处不通过）并且是否在wordList中
                        // 如果判断通过则加入到第三个set中（也就是nextSet）
                        if (visited.add(nextWord) && wordListSet.contains(nextWord)) nextSet.add(nextWord);
                        chars[i] = pre; // 恢复原本的单词
                    }
                }
            }
            /*
            ！！核心！！
            选择最小的那个set进行展开
            我们要走哪一个就把哪一个set变成beginSet
            然后将另一个变为endSet
            因为要对set中所有元素进行遍历，所以哪一个最小跑哪一个更快
             */
            if (endSet.size() < nextSet.size()) {
                beginSet = endSet;
                endSet = nextSet;
            } else {
                beginSet = nextSet;
            }
            step++;
        }
        return 0;
    }

    /*
    练习
     */
    public int ladderLength03(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step + 1;
                for (int j = 0; j < cur.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(j, c);
                        String temp = sb.toString();
                        if (hashSet.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return step + 1;
                            }
                            hashSet.remove(temp);
                            queue.offer(temp);

                        }
                    }
                }
            }
            step += 1;
        }
        return 0;
    }

    /*
    练习
    双向bfs
     */
    public int ladderLength04(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int n = beginWord.length();
        int step = 1;
        if (!hashSet.contains(endWord)) return 0;
        begin.add(beginWord);
        end.add(endWord);

        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String cur : begin) {
                char[] crr = cur.toCharArray();
                for (int i = 0; i < n; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char temp = crr[i];
                        crr[i] = c;
                        String nextWord = new String(crr);
                        if (end.contains(nextWord)) return step + 1;
                        if (visited.add(nextWord) && wordList.contains(nextWord)) next.add(nextWord);
                        crr[i] = temp;
                    }
                }
            }
            if (end.size() < next.size()) {
                begin = end;
                end = next;
            } else {
                begin = next;

            }
            step += 1;
        }
        return 0;
    }


    /*
    练习
    双向bfs
     */
    public int ladderLength05(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int n = beginWord.length();
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String temp = q.poll();
                if (temp.equals(endWord)) return step;
                for (int i = 0; i < n; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(temp);
                        sb.setCharAt(i, c);
                        String next = sb.toString();
                        if (set.contains(next)) {
                            if (next == endWord) return step + 1;
                        }
                        set.remove(next);
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return 0;
    }

}
