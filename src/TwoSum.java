/**
 * {comment here!!}
 * User: yangmu
 * Date: 2019-05-23
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
