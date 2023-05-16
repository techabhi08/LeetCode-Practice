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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            ListNode nex = curr.next;
            curr.next = nex.next;
            nex.next = curr;
            
            prev.next = nex;
            prev = curr;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}