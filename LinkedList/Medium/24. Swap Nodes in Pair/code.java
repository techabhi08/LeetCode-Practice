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
        if(head == null){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        
        while(temp != null && temp.next != null){
            ListNode nex = temp.next;
            temp.next = nex.next;
            nex.next = temp;
            prev.next = nex;
            prev = temp;
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
