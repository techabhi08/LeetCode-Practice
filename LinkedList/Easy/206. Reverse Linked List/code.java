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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode nex = pres.next;
        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        return prev;
    }
}
