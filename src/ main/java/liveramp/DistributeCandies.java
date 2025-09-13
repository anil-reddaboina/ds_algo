package liveramp;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class DistributeCandies {

    /**
     * Alice has n candies where the i-th candy is of type candyType[i].
     * Determine the maximum number of different types of candies Alice can eat.
     * This tests your hash table and array processing abilities.
     * @param candies
     *
     * Input: candyType = [1,1,2,2,3,3]
     * Output: 3
     * Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
     */
    //Time complexity is o(n) or space complexity is O(n)

    static  int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        Set<Integer> uniqueTypes = new HashSet<>(candies.length);
        //Set<Integer> UniqueCandies = Arrays.stream(candies).boxed().collect(Collectors.toSet());
        for(int candy: candies) {
            uniqueTypes.add(candy); //4 unique types
        }
        int maxAllowedToEat = candies.length/2; //2
        return  Math.min(uniqueTypes.size(), maxAllowedToEat);
    }


    public static void main(String[] args) {
        int[] candies =  {1,1,3,4,5};
       System.out.println(distributeCandies(candies));
    }

}
