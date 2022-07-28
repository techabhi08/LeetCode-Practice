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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        
        ListNode lHead = left;
        ListNode rHead = right;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                lHead.next = curr;
                lHead = lHead.next;
            }else{
                rHead.next = curr;
                rHead = rHead.next;
            }
            curr = curr.next;
        }
        lHead.next = right.next;
        rHead.next = null;
        return left.next;
    }
}
