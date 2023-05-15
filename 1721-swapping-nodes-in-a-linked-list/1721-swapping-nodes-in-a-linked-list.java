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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        int i = 0;
        ListNode start = head, end = head;
        
        while(start != null && i < k - 1){
            start = start.next;
            i++;
        }
        
        i = 0;
        while(end != null && i < size - k){
            end = end.next;
            i++;
        }
        
        int val = start.val;
        start.val = end.val;
        end.val = val;
        return head;
    }
}