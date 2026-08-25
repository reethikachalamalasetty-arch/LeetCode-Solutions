class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // Check if there are at least k nodes
        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the remaining nodes
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}