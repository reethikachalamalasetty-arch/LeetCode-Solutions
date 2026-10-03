class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Check if current node has duplicates
            if (current.next != null &&
                current.val == current.next.val) {

                int duplicateValue = current.val;

                // Skip all nodes with the duplicate value
                while (current != null &&
                       current.val == duplicateValue) {
                    current = current.next;
                }

                prev.next = current;

            } else {
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}