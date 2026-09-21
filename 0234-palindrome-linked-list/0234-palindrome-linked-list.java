class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode secondHalf = reverse(slow);

        // 3. Compare first half and second half
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}