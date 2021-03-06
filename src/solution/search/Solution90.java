package solution.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素求子集
 * 90. Subsets II (Medium)
 * https://leetcode.com/problems/subsets-ii/
 * For example,
 * If nums = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution90 {
    boolean[] hasVisted;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        hasVisted = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i=1; i<=nums.length; i++) {
            doSubsets(res, new ArrayList<>(), nums, i, 0);
        }
        return res;
    }

    private void doSubsets(List<List<Integer>> res, List<Integer> subset, final int[] nums, int size, int start) {
        if (subset.size() == size) {    //找到一个解
            res.add(new ArrayList<>(subset));
            return ;
        }

        for (int i=start; i<nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1] && !hasVisted[i-1])
                continue;

            subset.add(nums[i]);
            hasVisted[i] = true;
            doSubsets(res, subset, nums, size, i+1);
            hasVisted[i] = false;
            subset.remove(subset.size()-1);
        }
    }
}
