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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
        
        for(int i = 0; temp != null && i < left - 1; i++){
            prev = temp;
            temp = temp.next;
        }
        
        ListNode start = prev;
        ListNode newEnd = temp;
        ListNode nex = temp.next;
        
        for(int i = 0; temp != null && i < right - left + 1; i++){
            temp.next = prev;
            prev = temp;
            temp = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        
        if(start != null){
            start.next = prev;
        }else{
            head = prev;
        }
        
        newEnd.next = temp;
        return head;
    }
}