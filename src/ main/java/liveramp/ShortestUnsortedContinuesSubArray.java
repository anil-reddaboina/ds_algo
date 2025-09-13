package liveramp;

import java.util.Arrays;

public class ShortestUnsortedContinuesSubArray {
    /**
     * Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order,
     * then the whole array will be sorted in non-decreasing order.
     * Return the shortest such subarray and output its length
     * Example 1:
     * Input: nums = [2,6,4,8,10,9,15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     *
     * @param inputs
     * @return
     */
    //this approach time complexity is o(NLogN) because we are doing the sort
    //Space complexity O(N) as we are using the extra temp array

    static int sortedSubArray(int[] inputs) {
        int[] temp = new int[inputs.length];
        System.arraycopy(inputs, 0, temp, 0, inputs.length);
        Arrays.sort(inputs);

        int start=0, end = inputs.length-1;

        for(; start <= end; start++) {
            if(inputs[start] != temp[start]) break;
        }

        if(start>=end) return 0;

        for (; end >=0; end--) {
            if(inputs[end] != temp[end]) break;
        }

        return end-start+1;
    }


    //input: nums = [2,6,4,8,10,9,15]
    //create the min and max variables and store those in variables
    // walkthrough the array to find the decreasing value and increasing values
    // if the next position of an element is greater than the current position take that into max
    // if the before position is greater than the current position take that into min

    static int optimized(int[] inputs) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int length = inputs.length;
        for (int i = 1; i < length ; i ++) {
            //decreasing value
            if (inputs[i] < inputs[i-1]) {
                min = Math.min(min, inputs[i]);
            }
        }

        for(int j = length-2; j >= 0; j--) {
            //to find teh increasing value
          if(inputs[j] > inputs[j+1]) {
              max = Math.max(max, inputs[j]);
          }
        }
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;

        int start = 0, end = length-1;

        for (; start < length; start++) {
            if (inputs[start] > min) break;
        }

        for (; end >= 0; end--) {
            if (inputs[end] < max) break;
        }

        System.out.println(end + " : " + start);
        return end - start+1;

    }


    public static void main(String[] args) {
        int[] inputs = {2,6,4,8,10,9,15};
        System.out.println(optimized(inputs));
    }
}
