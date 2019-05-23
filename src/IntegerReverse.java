/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * User: yangmu
 * Date: 2019-05-23
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class IntegerReverse {
    public int reverse(int x) {
        int result = 0;
        try {
            while (true) {
                final boolean shouldBreak = (x / 10 == 0 && x % 10 == 0);
                if (shouldBreak) {
                    break;
                }
                int rightNum = x % 10;
                final int i = Math.multiplyExact(result, 10);
                result = Math.addExact(i, rightNum);

                x /= 10;
            }
        } catch (ArithmeticException e) {
            return 0;
        }
        return result;
    }
}
