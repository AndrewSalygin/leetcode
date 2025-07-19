package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, new ArrayList<>(), nums);
        return result;
    }

    private void backtracking(int index, List<Integer> tempList, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(nums[index]);
        backtracking(index + 1, tempList, nums);
        tempList.removeLast();
        backtracking(index + 1, tempList, nums);
    }
}
