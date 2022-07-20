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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newStart = dummy;
        int i = 0;
        
        while(head != null){
            i++;
            if(i % k == 0){
                newStart = reverse(newStart, head.next);
                head = newStart.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode start, ListNode end){
        
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode nex = curr.next;
        ListNode temp = curr;
        
        while(curr != end){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        
        start.next = prev;
        temp.next = curr;
        return temp;
    }
}
