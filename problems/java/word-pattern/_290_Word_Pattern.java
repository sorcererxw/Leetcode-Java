import util.Utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/11 0011.
 * <p>
 * https://leetcode.com/problems/word-pattern/
 */
public class _290_Word_Pattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("", "beef"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] patterns = pattern.split("");
        String[] strs = str.split(" ");
        if (pattern.length()==0 || patterns.length != strs.length) {
            return false;
        }
        List list = Arrays.asList(strs);
        for (int i = 0; i < patterns.length; i++) {
            for (int j = i + 1; j < pattern.length(); j++) {
                if (patterns[i].charAt(0) > patterns[j].charAt(0)) {
                    String t = patterns[i];
                    patterns[i] = patterns[j];
                    patterns[j] = t;
                    Collections.swap(list, i, j);
                }
            }
        }
        for (int i = 1; i < patterns.length; i++) {
            if (patterns[i].equals(patterns[i - 1])) {
                if (!list.get(i).equals(list.get(i - 1))) {
                    return false;
                }
            } else {
                if (list.get(i).equals(list.get(i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
