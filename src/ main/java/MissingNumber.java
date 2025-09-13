import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4};
        int missing = findMissing(nums);
        System.out.println(missing);
    }

    private static int findMissing(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[length-1] != length) {
            return  length;
        }
        for (int i =0; i < length; i ++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
}
