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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        int sum = 0;
        
        ListNode head1 = l1;
        ListNode head2 = l2;
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        while(head1 != null || head2 != null || sum != 0){
            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }
            
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            head.next = node;
            head = head.next;
            sum /= 10;
        }
        
        dummy = reverse(dummy.next);
        return dummy;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
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