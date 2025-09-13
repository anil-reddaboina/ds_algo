public class MergetTwoLists {

    public static void main(String[] args) {
       ListNode input1 = new ListNode(1, new ListNode(2));
        ListNode input2 = new ListNode(1, new ListNode(3));
        ListNode result = mergeSortedList(input1, input2);

        System.out.println(result);
    }

    /**
     * Dummy node act as first node
     * Second node as current node
     * compare the values and add to the dummy node
     * move the pointers
     *
     */

    /**
     * Time complexity O(N) && Space complexity is 0(1)
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode approach3(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current = l1.next;
                l1 = l1.next;
            } else {
                current = l2.next;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;
        return result.next;
    }

    private static ListNode mergetList(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = result;

        while( l1 !=null && l2 != null) {
            if(l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next =l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next =l1!=null?l1:l2;
        return result.next;

    }

    private static ListNode mergeSortedList(ListNode input1, ListNode input2) {

        if(input1 == null && input2 == null) {
            return new ListNode();
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (input1!=null && input2!=null) {
            //merge List
            if (input1.val <= input2.val) {
                current.next = input1;
                input1 = input1.next;
            } else {
                current.next = input2;
                input2 = input2.next;
            }
            current = current.next;
        }
        current.next=input1!=null ? input1:input2;
            return dummy.next;
        }
}


    class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

