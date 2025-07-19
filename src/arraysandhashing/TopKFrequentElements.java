package arraysandhashing;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> frequencies = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            frequencies.add(new ArrayList<>());
        }
        for (var entry : map.entrySet()) {
            frequencies.get(entry.getValue() - 1).add(entry.getKey());
        }

        int[] kMax = new int[k];
        int localK = 0;
        for (int i = frequencies.size() - 1; i >= 0; i--) {
            if (localK >= k) {
                break;
            }
            for (int j = frequencies.get(i).size() - 1; j >= 0; j--) {
                kMax[localK] = frequencies.get(i).get(j);
                localK++;
            }
        }
        return kMax;
    }
}
