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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        ListNode end = head;
        while(end.next != null && end.next.next != null){
            temp = temp.next;
            end = end.next.next;
        }
        if(end.next != null){
            temp = temp.next;
        }
        return temp;
    }
}
