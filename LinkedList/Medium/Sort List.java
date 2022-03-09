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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode h3 = dummy;
        
        while(left != null && right != null){
            if(left.val < right.val){
                h3.next = left;
                left = left.next;
                h3 = h3.next;
            }else{
                h3.next = right;
                right = right.next;
                h3 = h3.next;
            }
        }
        if(left != null){
            h3.next = left;
        }
        if(right != null){
            h3.next = right;
        }
        
        return dummy.next;
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode prev = null;
        while(head != null && head.next != null){
            if(prev == null){
                prev = head;
            }else{
                prev = prev.next;
            }
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }
}
