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
        
        ListNode revHead = reverse(slow);
        ListNode curr = head;
        
        while(curr != slow && revHead != null){
            if(curr.val != revHead.val){
                return false;
            }
            curr = curr.next;
            revHead = revHead.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode nex = curr.next;
        
        while(curr != null){
            curr.next = prev;
            
            prev = curr;
            curr = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        return prev;
    }
}