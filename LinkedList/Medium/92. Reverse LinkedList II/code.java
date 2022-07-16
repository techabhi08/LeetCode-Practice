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
        ListNode present = head;
        for(int i = 0; present != null && i < left - 1; i++){
            prev = present;
            present = present .next;
        }
        
        ListNode first = prev;
        ListNode newEnd = present;
        
        ListNode nex = present.next;
        
        for(int i = 0; present != null && i < right - left + 1; i++){
            present.next = prev;
            prev = present;
            present = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        if(first != null){
            first.next = prev;
        } else {
            head = prev;
        }
        
        newEnd.next = present;
        return head;
    }
}
