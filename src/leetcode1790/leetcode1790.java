package leetcode1790;

public class leetcode1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String s1Alter = "", s2Alter = "";
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                s1Alter += s1.charAt(i);
                s2Alter += s2.charAt(i);
                if (s1Alter.length() > 2) {
                    return false;
                }
            }
        }
        return (s1Alter.length() == 2) && (s1Alter.equals(s2Alter));
    }
}
