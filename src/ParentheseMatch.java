import java.util.*;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * User: yangmu
 * Date: 2019-05-23
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class ParentheseMatch {

    public static void main(String[] args) {
        System.out.println(new ParentheseMatch().isValid("["));
    }

    public boolean isValid(String s) {
        Map<Character, Character> pushPopMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        Stack<Character> t = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            final char token = s.charAt(i);
            if (pushPopMap.containsKey(token)) {
                t.push(token);
            } else {
                if (t.size() == 0) {
                    return false;
                }
                final Character key = t.pop();
                final Character compare = pushPopMap.get(key);
                if (!compare.equals(token)) {
                    return false;
                }
            }
        }
        if (t.size() != 0) {
            return false;
        }
        return true;
    }
}
