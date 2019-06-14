import java.util.*;

/**
 * {comment here!!}
 * User: yangmu
 * Date: 2019-05-25
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-15, 6, 7, 0, -14, -5, -3, -10, -14, 1, -14, -1, -11, -11, -15, -1, 3, -12, 7, 14, 1, 6, -6, 7, 1, 1, 0, -4, 8, 7, 2, 1, -2, -6, -14, -9, -3, -1, -12, -2, 7, 11, 4, 12, -14, -4, -4, 4, -1, 10, 3, -14, 1, 12, 0, 10, -9, 8, -9, 14, -8, 8, 0, -3, 10, -6, 4, -8, 0, -1, -3, -8, -4, 8, 11, -3, -11, -8, 8, 3, 10, -3, -4, -4, -14, 12, 13, -8, -3, 12, -8, 4, 5, -1, -14, -8, 8, -3, -9, -15, 12, -5, -7, -15, -12, 11, -11, 14, 11, 12, 3, 6, -6};
        int[] nums2 = {-1, 0, 1, 2, -1, -4};

        System.out.println(new ThreeSum().threeSum(nums2));

    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        Set<List<Integer>> container = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        final Integer[] a = {nums[i], nums[j], nums[k]};
                        container.add(Arrays.asList(a));
                    }
                }
            }
        }
        return new ArrayList<>(container);
    }
}
