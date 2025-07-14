/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val; // Left shift result by 1 and add current bit
            head = head.next;
        }
        return result;
    }
}
