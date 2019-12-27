package com.wzl.leetcode;

import java.util.*;


/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 最暴力的方法是两次for循环遍历,时间复杂度是O(n^2)
 * 优化点在于怎么快速查询出来值。
 * 采用hashMap的方式,key是hash存储,能够快速搜索到key
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20190927 19:53:59
 */
public class TowSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((Math.log10(i) + 1) / 2 > 0) {
                count++;
            }
        }
        return count;
    }

    public static int numJewelsInStones(String J, String S) {
        char[] chars = J.toCharArray();
        int count = 0;
        HashSet hashSet = new HashSet();
        for (char c: chars) {
            hashSet.add(c);
        }
        char[] chars1 = S.toCharArray();
        for (char c : chars1) {
            if (hashSet.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
