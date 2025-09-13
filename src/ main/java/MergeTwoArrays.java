public class MergeTwoArrays {
    public static void main(String[] args) {

        int[] input1 = new int[]{1,2,4, 0, 0, 0};
        int[] input2 = new int[]{2,5,6 };
        int n = 3;
        int m = 3;
        mergeTwoArrays(input1, m, input2, n);
       System.out.println(input1.toString());
    }

    /**
     * This solution implemented using TWO pointer solution
     * Pointer p1 at array 1 last elements index position, that is 3rd position
     * pointer p2 at array 2 last index position
     * i here is the array1 last index position that assumed new length m+n-1
     * first checks the p1 > P2 , if yes copy the value to the Array1 i position from P2
     * then decrease the p2 and p1
     *
     */
    private static void  mergeTwoArrays(int[] input1, int m, int[] input2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && input1[p1] > input2[p2]) {
                input1[i--] = input1[p1--];
            } else {
                input1[i--] = input2[p2--];
            }
        }
    }
}
