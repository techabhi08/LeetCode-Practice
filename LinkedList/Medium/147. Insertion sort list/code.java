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
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode curr = head.next;
        ListNode prev = head;
        
        while(curr != null){
            if(curr.val >= prev.val){
                prev = prev.next;
                curr = curr.next;
            }else{
                prev.next = curr.next;
                if(curr.val <= head.val){
                    curr.next = head;
                    head = curr;
                }else{
                    ListNode temp = head;
                    while(temp != null && temp.next.val < curr.val){
                        temp = temp.next;
                    }
                    curr.next = temp.next;
                    temp.next = curr;
                }
            }
            curr = prev.next;
        }
        
        return head;
    }
}
