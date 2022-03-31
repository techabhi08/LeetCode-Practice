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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode revStart = reverse(slow);
        ListNode start = head;
        while(start != slow){
            if(start.val != revStart.val){
                return false;
            }
            start = start.next;
            revStart = revStart.next;  
        }
        return true;
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
