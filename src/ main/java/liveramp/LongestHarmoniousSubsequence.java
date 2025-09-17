package liveramp;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
        public static void main (String[]args){
            int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
            System.out.println("Longest harmonious subsequence for nums1: " + findLHS(nums1)); // Expected: 5

            int[] nums2 = {1, 2, 3, 4};
            System.out.println("Longest harmonious subsequence for nums2: " + findLHS(nums2)); // Expected: 2

            int[] nums3 = {1, 1, 1, 1};
            System.out.println("Longest harmonious subsequence for nums3: " + findLHS(nums3)); // Expected: 0
        }

        /**
         * Finds the length of the longest harmonious subsequence.
         * A harmonious subsequence is one where the difference between the max and min element is 1.
         *
         * Time Complexity: O(n) - We iterate through the array once to build the map,
         *                 and then iterate through the unique keys (at most n) once.
         * Space Complexity: O(k) - Where k is the number of unique elements in the array.
         *                  In the worst case, this is O(n).
         *
         * @param nums The input array of integers.
         * @return The length of the longest harmonious subsequence.
         */
        public static int findLHS ( int[] nums){
            // Edge case: A harmonious subsequence needs at least two numbers.
            if (nums == null || nums.length < 2) {
                return 0;
            }

            // 1. Count the frequency of each number.
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            int maxLength = 0;

            // 2. Iterate through the numbers in the map to find harmonious pairs.
            for (int num : frequencyMap.keySet()) {
                // Check if the map contains the complementary number (num + 1).
                if (frequencyMap.containsKey(num + 1)) {
                    // Calculate the length of this harmonious subsequence.
                    int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                    // Update the maximum length found so far.
                    maxLength = Math.max(maxLength, currentLength);
                }
            }

            // 3. Return the final result.
            return maxLength;
        }
    }
