import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = thirdSolution(nums, target);
        System.out.println(Arrays.toString(result));
    }

    //most appropriate solution
    private static int[] thirdSolution(int[] nums, int target) {
        HashMap<Integer, Integer> visitedMap = new HashMap<>();
        for (int i =0; i< nums.length; i++) {
            int result = target - nums[i];
            if (visitedMap.containsKey(result)) {
                return new int[]{visitedMap.get(result), i};
            }
            visitedMap.put(nums[i], i);
        }

        return new int[]{};
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
        return result;
        }
        HashMap<Integer, Integer> visitedKey = new HashMap<>();

        for (int i =0; i < nums.length; i ++) {
            visitedKey.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(visitedKey.containsKey(target-nums[i]) &&
            visitedKey.get(target-nums[i]) != i){
                result[0] = visitedKey.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            visitedKey.put(target - nums[i], i);
        }
        return result;

    }

    public static int[] approach2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length-1; i++) { // 0
            for (int j = i+1; j < nums.length; j ++) { // 1
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};

    }
}