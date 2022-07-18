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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode revStart = reverse(slow);
        
        ListNode start = head;

        
        while(start != null && revStart != null){
            ListNode temp = start.next;
            start.next = revStart;
            start = temp;
            
            temp = revStart.next;
            revStart.next = start;
            revStart = temp;
        }
        
        // start.next = null;
        if(start != null){
            start.next = null;
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        ListNode nex = present.next;
        
        while(present != null){
            present.next = prev;
            prev = present;
            present = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        return prev;
    }
}
