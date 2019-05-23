import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * User: yangmu
 * Date: 2019-05-23
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

}
