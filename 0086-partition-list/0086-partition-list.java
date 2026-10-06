class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smaller = new ListNode(0);
        ListNode greater = new ListNode(0);

        ListNode small = smaller;
        ListNode large = greater;

        while (head != null) {

            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }

        // End the greater/equal list
        large.next = null;

        // Connect both lists
        small.next = greater.next;

        return smaller.next;
    }
}