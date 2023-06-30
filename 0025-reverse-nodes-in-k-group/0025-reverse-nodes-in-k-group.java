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
        if(head == null || k == 0){
            return null;
        }
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        dummy.next = head;
        
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                temp = reverse(temp, head.next);
                head = temp.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, ListNode end){
        ListNode prev = head;
        ListNode curr = head.next;
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
        
        temp.next = curr;
        head.next = prev;
        return temp;
    }
}